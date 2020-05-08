package com.carnote.controller;

import com.carnote.model.entity.Expense;
import com.carnote.model.entity.FuelExpense;
import com.carnote.model.entity.Vehicle;
import com.carnote.model.viewModel.ExpenseFormViewModel;
import com.carnote.model.viewModel.FuelExpenseFormViewModel;
import com.carnote.service.ExpTypeService;
import com.carnote.service.ExpenseService;
import com.carnote.service.FuelExpenseService;
import com.carnote.service.VehicleService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

@Controller
public class ExpenseController {

    @Autowired
    VehicleService vehicleService;

    @Autowired
    ExpenseService expenseService;

    @Autowired
    FuelExpenseService fuelExpenseService;

    @Autowired
    ExpTypeService expTypeService;

    private static final String UPLOAD_DIRECTORY ="/resources/files";

    @RequestMapping(value="/expense", method = RequestMethod.GET)
    public String expensePage(Map<String, Object> map, @RequestParam(value = "eId") Integer expenseId) {

        Expense expense = expenseService.getExpense(expenseId);

        map.put("expense", expense);
        return "expense";
    }

    @RequestMapping(value="/fuelExpense", method = RequestMethod.GET)
    public String fuelExpensePage(Map<String, Object> map, @RequestParam(value = "eId") Integer expenseId) {

        FuelExpense expense = fuelExpenseService.getFuelExpense(expenseId);

        map.put("expense", expense);
        return "fuelExpense";
    }

    @RequestMapping(value="/newExpense", method = RequestMethod.GET)
    public String newExpensePage(Map<String, Object> map, @RequestParam(value = "vId") Integer vehicleId) {

        Vehicle vehicle = vehicleService.getVehicle(vehicleId);

        map.put("expense", new ExpenseFormViewModel());
        map.put("vehicle", vehicle);
        return "newExpense";
    }

    @RequestMapping(value="/editExpense", method = RequestMethod.GET)
    public String editExpensePage(Map<String, Object> map, @RequestParam(value = "eId") Integer expenseId) {

        Expense expense = expenseService.getExpense(expenseId);

        map.put("oldExpense", expense);
        map.put("expense", new ExpenseFormViewModel());
        return "editExpense";
    }

    @RequestMapping(value="/deleteExpense", method = RequestMethod.GET)
    public String deleteExpense(@RequestParam(value = "eId") Integer expenseId) {

        int vehicleId = expenseService.getExpense(expenseId).getCar().getId();

        expenseService.delete(expenseId);

        return "redirect:/vehicle?vId="+vehicleId;
    }

    @RequestMapping(value="/deleteFuelExpense", method = RequestMethod.GET)
    public String deleteFuelExpense(@RequestParam(value = "eId") Integer expenseId) {

        int vehicleId = fuelExpenseService.getFuelExpense(expenseId).getCar().getId();

        fuelExpenseService.delete(expenseId);

        return "redirect:/vehicle?vId="+vehicleId;
    }

    @RequestMapping(value="/addExpense", method= RequestMethod.POST)
    public String addExpense(@Valid @ModelAttribute ExpenseFormViewModel expense, BindingResult br) {

        int id = expense.getCarId();

        if (br.hasErrors()) {
            return "redirect:/newExpense?vId="+id;
        }

        else {

            Expense expenseToAdd = new Expense(vehicleService.getVehicle(expense.getCarId()), expense.getName(), expTypeService.getExpType(expense.getTypeId()),
                    expense.getDate(), expense.getMilage(), expense.getPrice(), expense.getDescription());

            expenseService.add(expenseToAdd);

            return "redirect:/vehicle?vId="+id;
        }
    }

    @RequestMapping(value="/updateExpense", method= RequestMethod.POST)
    public String updateExpense(@Valid @ModelAttribute ExpenseFormViewModel expense, BindingResult br) {

        int id = expense.getId();

        if (br.hasErrors()) {
            return "redirect:/editExpense?eId="+id;
        }

        else {

            Expense expenseToAdd = new Expense(expense.getId(), vehicleService.getVehicle(expense.getCarId()), expense.getName(),
                    expTypeService.getExpType(expense.getTypeId()), expense.getDate(), expense.getMilage(), expense.getPrice(), expense.getDescription());

            expenseService.edit(expenseToAdd);

            return "redirect:/vehicle?vId="+id;
        }
    }

    @RequestMapping(value="/newFuelExpense", method = RequestMethod.GET)
    public String newFuelExpensePage(Map<String, Object> map, @RequestParam(value = "vId") Integer vehicleId, @RequestParam(value = "ft") Integer fType) {

        Vehicle vehicle = vehicleService.getVehicle(vehicleId);

        map.put("expense", new FuelExpenseFormViewModel());
        map.put("vehicle", vehicle);
        map.put("fuel", fType);
        return "newFuelExpense";
    }

    @RequestMapping(value="/addFuelExpense", method= RequestMethod.POST)
    public String addFuelExpense(@Valid @ModelAttribute FuelExpenseFormViewModel expense, BindingResult br) {

        int id = expense.getCarId();
        int ft = expense.getFtype();

        if (br.hasErrors()) {
            return "redirect:/newFuelExpense?vId="+id+"&ft="+ft;
        }

        else {

            FuelExpense expenseToAdd = new FuelExpense(vehicleService.getVehicle(expense.getCarId()), expense.getName(), expTypeService.getExpType(expense.getTypeId()),
                    expense.getFtype(), expense.getDate(), expense.getMilage(), expense.getPrice(), expense.getLitres(), expense.getLevel());

            fuelExpenseService.add(expenseToAdd);

            return "redirect:/vehicle?vId="+id;
        }
    }

    @RequestMapping(value="/editFuelExpense", method = RequestMethod.GET)
    public String editFuelExpensePage(Map<String, Object> map, @RequestParam(value = "eId") Integer expenseId) {

        FuelExpense expense = fuelExpenseService.getFuelExpense(expenseId);

        map.put("oldExpense", expense);
        map.put("expense", new FuelExpenseFormViewModel());
        return "editFuelExpense";
    }

    @RequestMapping(value="/updateFuelExpense", method= RequestMethod.POST)
    public String updateFuelExpense(@Valid @ModelAttribute FuelExpenseFormViewModel expense, BindingResult br) {

        int exId = expense.getId();
        int vId = expense.getCarId();

        if (br.hasErrors()) {
            return "redirect:/editFuelExpense?eId="+exId;
        }

        else {

            FuelExpense expenseToAdd = new FuelExpense(expense.getId(), vehicleService.getVehicle(expense.getCarId()), expense.getName(), expTypeService.getExpType(expense.getTypeId()),
                    expense.getFtype(), expense.getDate(), expense.getMilage(), expense.getPrice(), expense.getLitres(), expense.getLevel());

            fuelExpenseService.edit(expenseToAdd);

            return "redirect:/vehicle?vId="+vId;
        }
    }

    @RequestMapping(value = "/importFromExcel", method = RequestMethod.POST)
    public String importFromExcel(Map<String, Object> map, @RequestParam String vehicleId,
                                  @RequestParam CommonsMultipartFile file, ModelMap modelMap, HttpSession session) throws IOException {

        Vehicle vehicle = vehicleService.getVehicle(Integer.parseInt(vehicleId));

        fileUpload(file, session);

        String file_directory ="/resources/files/expenses.xlsx";

        ServletContext context = session.getServletContext();
        String path = context.getRealPath(file_directory);

        File excelFile = new File(path);
        FileInputStream fis = new FileInputStream(excelFile);

        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);

        Iterator<Row> rowIt = sheet.iterator();

        rowIt.next();

        while(rowIt.hasNext()) {

            Row row = rowIt.next();

            Iterator<Cell> cellIterator = row.cellIterator();

            String name = cellIterator.next().toString();
            String type = cellIterator.next().toString();
            String date = cellIterator.next().toString();
            int milage = (int)ParseFloat(cellIterator.next().toString());
            float price = ParseFloat(cellIterator.next().toString());

            DateFormat dateFormatXLSX1 = new SimpleDateFormat("dd-MMM-yyyy");
            DateFormat dateFormatXLSX2 = new SimpleDateFormat("yyyy-mm-dd");
            DateFormat dateFormatXLSX3 = new SimpleDateFormat("dd.mm.yyyy");
            DateFormat dateFormatSQL = new SimpleDateFormat("yyyy-mm-dd");
            Date tempDate = null;
            try {
                tempDate = dateFormatXLSX1.parse(date);
            } catch (ParseException e) {
                try {
                    tempDate = dateFormatXLSX2.parse(date);
                } catch (ParseException ex) {
                    try {
                        tempDate = dateFormatXLSX3.parse(date);
                    } catch (ParseException exc) {
                        exc.printStackTrace();
                        String warning = "Provide correctly formatted data!";
                        return "redirect:/vehicle?vId="+vehicleId+"&warn="+warning;
                    }
                }
            }
            date = dateFormatSQL.format(tempDate);

            if (type.equalsIgnoreCase("fuel")) {

                float litres = ParseFloat(cellIterator.next().toString());
                int level = (int)ParseFloat(cellIterator.next().toString());

                int ftype;

                if (name.equalsIgnoreCase("PB")) {
                    ftype = 1;
                }

                else if (name.equalsIgnoreCase("ON")) {
                    ftype = 2;
                }

                else {
                    ftype = 3;
                }

                FuelExpense expense = new FuelExpense(vehicle, name, expTypeService.getExpTypeByName(type), ftype,
                        date, milage, price, litres, level);

                fuelExpenseService.add(expense);
            }

            else {

                String description = cellIterator.next().toString();

                Expense expense = new Expense(vehicle, name, expTypeService.getExpTypeByName(type), date, milage,
                        price, description);

                expenseService.add(expense);
            }
        }

        modelMap.put("file", file);
        modelMap.put("vehicleId", vehicleId);

        return "redirect:/vehicle?vId="+vehicleId;
    }

    private void fileUpload(CommonsMultipartFile file, HttpSession session) throws IOException {

        ServletContext context = session.getServletContext();
        String path = context.getRealPath(UPLOAD_DIRECTORY);
        String filename = "expenses.xlsx";

        byte[] bytes = file.getBytes();
        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(
                new File(path + File.separator + filename)));
        stream.write(bytes);
        stream.flush();
        stream.close();
    }

    private float ParseFloat(String strNumber) {
        if (strNumber != null && strNumber.length() > 0) {
            try {
                return Float.parseFloat(strNumber);
            } catch(Exception e) {
                return -1;   // or some value to mark this field is wrong. or make a function validates field first ...
            }
        }
        else return 0;
    }
}
