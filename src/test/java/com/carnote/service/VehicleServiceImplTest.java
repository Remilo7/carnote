package com.carnote.service;

import com.carnote.dao.VehicleDAO;
import com.carnote.model.entity.Vehicle;
import com.carnote.service.impl.VehicleServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class VehicleServiceImplTest {

    @TestConfiguration
    static class VehicleServiceImplTestContextConfiguration {

        @Bean
        public VehicleService vehicleService() {
            return new VehicleServiceImpl();
        }
    }

    @Autowired
    private VehicleService vehicleService;

    @MockBean
    VehicleDAO vehicleDAO;

    @Before
    public void setUp() {
        Vehicle audi = new Vehicle(1,"Audi","A4",2001,1,66,66,106500);

        Mockito.when(vehicleDAO.getVehicle(audi.getId()))
                .thenReturn(audi);
    }

    @Test
    public void whenValidId_thenVehicleShouldBeFound() {

        int id = 1;

        Vehicle found = vehicleService.getVehicle(id);

        assertThat(found.getId(),is(id));
    }
}
