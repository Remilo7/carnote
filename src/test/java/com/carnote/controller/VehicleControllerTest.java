package com.carnote.controller;

import com.carnote.configuration.ApplicationContextConfig;
import com.carnote.dao.VehicleDAO;
import com.carnote.model.entity.Vehicle;
import com.carnote.service.VehicleService;
import com.carnote.service.impl.VehicleServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationContextConfig.class })
@WebAppConfiguration
public class VehicleControllerTest {

    @Autowired
    private WebApplicationContext wac;

    @MockBean
    VehicleDAO vehicleDAO;

    private MockMvc mockMvc;

    @Before
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void givenWac_whenServletContext_thenItProvidesVehicleController() {
        ServletContext servletContext = wac.getServletContext();

        Assert.assertNotNull(servletContext);
        Assert.assertTrue(servletContext instanceof MockServletContext);
        Assert.assertNotNull(wac.getBean("vehicleController"));
    }

    @Test
    public void givenNewVehicleURI_whenMockMVC_thenReturnsNewVehicleJSPViewName() throws Exception {
        this.mockMvc.perform(get("/newVehicle"))
                .andDo(print())
                .andExpect(view().name("newVehicle"));
    }

    @Test
    public void givenProperData_whenPost_thenReturnIndexJSPViewName() throws Exception {
        this.mockMvc.perform(post("/addVehicle")
                    .param("id", "1")
                    .param("brand", "Audi")
                    .param("model", "A4")
                    .param("year", "2001")
                    .param("ftype", "1")
                    .param("cap1", "66")
                    .param("cap2", "0")
                    .param("level1", "66")
                    .param("level2", "0")
                    .param("milage", "106000"))
                .andExpect(view().name("redirect:/index"));
    }

    @Test
    public void givenTooLowYear_whenPost_thenReturnNewVehicleJSPViewName() throws Exception {
        this.mockMvc.perform(post("/addVehicle")
                .param("id", "1")
                .param("brand", "Audi")
                .param("model", "A4")
                .param("year", "1899")
                .param("ftype", "1")
                .param("cap1", "66")
                .param("cap2", "0")
                .param("level1", "66")
                .param("level2", "0")
                .param("milage", "106000"))
                .andExpect(view().name("newVehicle"));
    }

    @Test
    public void givenTooHighYear_whenPost_thenReturnNewVehicleJSPViewName() throws Exception {
        this.mockMvc.perform(post("/addVehicle")
                .param("id", "1")
                .param("brand", "Audi")
                .param("model", "A4")
                .param("year", "2041")
                .param("ftype", "1")
                .param("cap1", "66")
                .param("cap2", "0")
                .param("level1", "66")
                .param("level2", "0")
                .param("milage", "106000"))
                .andExpect(view().name("newVehicle"));
    }

    @Test
    public void givenNegativeCap1_whenPost_thenReturnNewVehicleJSPViewName() throws Exception {
        this.mockMvc.perform(post("/addVehicle")
                .param("id", "1")
                .param("brand", "Audi")
                .param("model", "A4")
                .param("year", "2001")
                .param("ftype", "1")
                .param("cap1", "-1")
                .param("cap2", "0")
                .param("level1", "66")
                .param("level2", "0")
                .param("milage", "106000"))
                .andExpect(view().name("newVehicle"));
    }

    @Test
    public void givenNegativeCap2_whenPost_thenReturnNewVehicleJSPViewName() throws Exception {
        this.mockMvc.perform(post("/addVehicle")
                .param("id", "1")
                .param("brand", "Audi")
                .param("model", "A4")
                .param("year", "2001")
                .param("ftype", "1")
                .param("cap1", "66")
                .param("cap2", "-1")
                .param("level1", "66")
                .param("level2", "0")
                .param("milage", "106000"))
                .andExpect(view().name("newVehicle"));
    }

    @Test
    public void givenNegativeLevel1_whenPost_thenReturnNewVehicleJSPViewName() throws Exception {
        this.mockMvc.perform(post("/addVehicle")
                .param("id", "1")
                .param("brand", "Audi")
                .param("model", "A4")
                .param("year", "2001")
                .param("ftype", "1")
                .param("cap1", "0")
                .param("cap2", "0")
                .param("level1", "-1")
                .param("level2", "0")
                .param("milage", "106000"))
                .andExpect(view().name("newVehicle"));
    }

    @Test
    public void givenNegativeLevel2_whenPost_thenReturnNewVehicleJSPViewName() throws Exception {
        this.mockMvc.perform(post("/addVehicle")
                .param("id", "1")
                .param("brand", "Audi")
                .param("model", "A4")
                .param("year", "2001")
                .param("ftype", "1")
                .param("cap1", "66")
                .param("cap2", "0")
                .param("level1", "66")
                .param("level2", "-1")
                .param("milage", "106000"))
                .andExpect(view().name("newVehicle"));
    }

    @Test
    public void givenNegativeMilage_whenPost_thenReturnNewVehicleJSPViewName() throws Exception {
        this.mockMvc.perform(post("/addVehicle")
                .param("id", "1")
                .param("brand", "Audi")
                .param("model", "A4")
                .param("year", "2001")
                .param("ftype", "1")
                .param("cap1", "66")
                .param("cap2", "0")
                .param("level1", "66")
                .param("level2", "0")
                .param("milage", "-1"))
                .andExpect(view().name("newVehicle"));
    }
}
