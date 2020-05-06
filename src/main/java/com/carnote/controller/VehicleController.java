package com.carnote.controller;

import com.carnote.model.entity.Expense;
import com.carnote.model.entity.FuelExpense;
import com.carnote.model.entity.Vehicle;
import com.carnote.model.viewModel.ExpenseViewModel;
import com.carnote.service.ExpenseService;
import com.carnote.service.FuelExpenseService;
import com.carnote.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Controller
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @Autowired
    ExpenseService expenseService;

    @Autowired
    FuelExpenseService fuelExpenseService;

    @RequestMapping(value="/newVehicle", method = RequestMethod.GET)
    public String newVehiclePage(Map<String, Object> map) {

        map.put("vehicle", new Vehicle());
        return "newVehicle";
    }

    @RequestMapping(value="/addVehicle", method= RequestMethod.POST)
    public String addVehicle(@Valid @ModelAttribute Vehicle vehicle, BindingResult br) {

        if (br.hasErrors()) {
            return "newVehicle";
        }

        else {

            vehicleService.add(vehicle);

            return "redirect:/index";
        }
    }

    @RequestMapping(value="/deleteVehicle", method= RequestMethod.GET)
    public String deleteVehicle(@RequestParam(value = "vId") Integer vehicleId) {

        vehicleService.delete(vehicleId);

        return "redirect:/index";
    }

    @RequestMapping(value = "/vehicle", method = RequestMethod.GET)
    public String vehiclePage(Map<String, Object> map, @RequestParam(value = "vId") Integer vehicleId) {

        Vehicle vehicle = vehicleService.getVehicle(vehicleId);

        List<Expense> expenses = expenseService.getAllExpense(vehicle);
        List<FuelExpense> fuelExpenses = fuelExpenseService.getAllFuelExpense(vehicle);

        List<ExpenseViewModel> allExpenses = new ArrayList<>();

        expenses.forEach(e -> allExpenses.add(new ExpenseViewModel(e)));
        fuelExpenses.forEach(fe -> allExpenses.add(new ExpenseViewModel(fe)));

        List<ExpenseViewModel> expenseList = allExpenses.stream()
                .sorted((Comparator.comparing(ExpenseViewModel::getDate).reversed()))
                .collect(Collectors.toList());

        float fuel_sum = fuelExpenses.stream()
                .map(x -> x.getPrice())
                .reduce((float)0, Float::sum);

        float exp_sum = expenses.stream()
                .filter(x -> x.getType().getId()==1)
                .map(x -> x.getPrice())
                .reduce((float)0, Float::sum);

        float rep_sum = expenses.stream()
                .filter(x -> x.getType().getId()==2)
                .map(x -> x.getPrice())
                .reduce((float)0, Float::sum);

        float mot_sum = expenses.stream()
                .filter(x -> x.getType().getId()==3)
                .map(x -> x.getPrice())
                .reduce((float)0, Float::sum);

        float ins_sum = expenses.stream()
                .filter(x -> x.getType().getId()==4)
                .map(x -> x.getPrice())
                .reduce((float)0, Float::sum);

        float oth_sum = expenses.stream()
                .filter(x -> x.getType().getId()==5)
                .map(x -> x.getPrice())
                .reduce((float)0, Float::sum);

        float sum = fuel_sum+exp_sum+rep_sum+mot_sum+ins_sum+oth_sum;

        Map<String, Float> fuelCons = getFuelCons(fuelExpenses, vehicle);

        try {
            Map<String, String> MOTandInsDates = getMOTandInsDates(expenses);

            map.put("motDate", MOTandInsDates.get("motDate"));
            map.put("insDate", MOTandInsDates.get("insDate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        map.put("vehicle", vehicle);
        map.put("expense", new ExpenseViewModel());
        map.put("expenseList", expenseList);

        map.put("fuel_sum", fuel_sum);
        map.put("exp_sum", exp_sum);
        map.put("rep_sum", rep_sum);
        map.put("mot_sum", mot_sum);
        map.put("ins_sum", ins_sum);
        map.put("oth_sum", oth_sum);
        map.put("sum", sum);

        map.put("lastMain", fuelCons.get("lastMain"));
        map.put("avgMain", fuelCons.get("avgMain"));

        if (vehicle.getFtype() == 3) {
            map.put("lastLPG", fuelCons.get("lastLPG"));
            map.put("avgLPG", fuelCons.get("avgLPG"));
        }

        return "vehicle";
    }

    private float calcLastFuelCons(int lastLevel, int presLevel, float tanked, int lastMilage, int presMilage) {

        float litres = lastLevel-presLevel+tanked;
        float distance = presMilage-lastMilage;

        return litres*100/distance;
    }

    private float calcAVGFuelCons(int l0, int ln, float tankSum, float distSum) {

        float litres = l0-ln+tankSum;

        return litres*100/distSum;
    }

    private Map<String, Float> getFuelCons(List<FuelExpense> expenses, Vehicle vehicle) {

        int ftype = vehicle.getFtype();
        int carLevel = vehicle.getLevel1();
        int carMilage = vehicle.getMilage();

        Map<String, Float> result = new HashMap<>();

        List<FuelExpense> fuelExpenses = expenses.stream()
                .filter(e -> (e.getFtype()==1 || e.getFtype()==2))
                .sorted(Comparator.comparing(FuelExpense::getMilage).reversed())
                .collect(Collectors.toList());

        if (fuelExpenses.size() == 0) {
            result.put("lastMain", (float)0);
            result.put("avgMain", (float)0);
        }

        else if (fuelExpenses.size() == 1) {
            FuelExpense fex = fuelExpenses.get(0);

            float cons = calcLastFuelCons(carLevel, fex.getLevel(), fex.getLitres(), carMilage, fex.getMilage());

            result.put("lastMain", cons);
            result.put("avgMain", cons);
        }

        else {

            float distSum = fuelExpenses.get(0).getMilage()-carMilage;
            float tankSum = fuelExpenses.stream()
                    .map(x -> x.getLitres())
                    .reduce((float)0, Float::sum);

            float lastMain = calcLastFuelCons(fuelExpenses.get(1).getLevel(), fuelExpenses.get(0).getLevel(), fuelExpenses.get(0).getLitres(),
                    fuelExpenses.get(1).getMilage(), fuelExpenses.get(0).getMilage());

            float avgMain = calcAVGFuelCons(carLevel, fuelExpenses.get(0).getLevel(), tankSum, distSum);

            result.put("lastMain", lastMain);
            result.put("avgMain", avgMain);
        }

        if(ftype == 3) {

            List<FuelExpense> lpgExpenses = expenses.stream()
                    .filter(e -> e.getFtype()==3)
                    .sorted(Comparator.comparing(FuelExpense::getMilage).reversed())
                    .collect(Collectors.toList());

            if (lpgExpenses.size() == 0) {
                result.put("lastLPG", (float)0);
                result.put("avgLPG", (float)0);
            }

            else if (lpgExpenses.size() == 1) {
                FuelExpense fex = lpgExpenses.get(0);

                float cons = calcLastFuelCons(carLevel, fex.getLevel(), fex.getLitres(), carMilage, fex.getMilage());

                result.put("lastLPG", cons);
                result.put("avgLPG", cons);
            }

            else {

                float distSum = lpgExpenses.get(0).getMilage()-carMilage;
                float tankSum = lpgExpenses.stream()
                        .map(x -> x.getLitres())
                        .reduce((float)0, Float::sum);

                float lastLPG = calcLastFuelCons(lpgExpenses.get(1).getLevel(), lpgExpenses.get(0).getLevel(), lpgExpenses.get(0).getLitres(),
                        lpgExpenses.get(1).getMilage(), lpgExpenses.get(0).getMilage());

                float avgLPG = calcAVGFuelCons(carLevel, lpgExpenses.get(0).getLevel(), tankSum, distSum);

                result.put("lastLPG", lastLPG);
                result.put("avgLPG", avgLPG);
            }
        }

        return result;
    }

    private Map<String, String> getMOTandInsDates(List<Expense> expenses) throws ParseException {

        Map<String, String> result = new HashMap<>();

        List<Expense> mots = expenses.stream()
                .filter(e -> e.getType().getId()==3)
                .sorted(Comparator.comparing(Expense::getDate).reversed())
                .collect(Collectors.toList());

        List<Expense> insurances = expenses.stream()
                .filter(e -> e.getType().getId()==4)
                .sorted(Comparator.comparing(Expense::getDate).reversed())
                .collect(Collectors.toList());

        Calendar c = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");

        if (mots.isEmpty()) {
            result.put("motDate", "No data");
        }

        else {
            Date motDate = new SimpleDateFormat("yyyy-mm-dd").parse(mots.get(0).getDate());

            c.setTime(motDate);
            c.add(Calendar.YEAR, 1);
            c.add(Calendar.DAY_OF_MONTH, -1);

            motDate = c.getTime();

            result.put("motDate", dateFormat.format(motDate));

        }

        if (insurances.isEmpty()) {
            result.put("insDate", "No data");
        }

        else {
            Date insDate = new SimpleDateFormat("yyyy-mm-dd").parse(insurances.get(0).getDate());

            c.setTime(insDate);
            c.add(Calendar.YEAR, 1);
            c.add(Calendar.DAY_OF_MONTH, -1);

            insDate = c.getTime();

            result.put("insDate", dateFormat.format(insDate));
        }

        return result;
    }
}
