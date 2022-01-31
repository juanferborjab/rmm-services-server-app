package com.ninjarmm.app.controller;

import com.ninjarmm.app.controller.request.DeviceRequest;
import com.ninjarmm.app.entity.Customer;
import com.ninjarmm.app.entity.device.Device;
import com.ninjarmm.app.entity.device.DeviceType;
import com.ninjarmm.app.service.DeviceService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@WebMvcTest(DeviceController.class)
class DeviceControllerTest  {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    DeviceService deviceService;

    DeviceType deviceType;

    String exampleDeviceJson = "{\"idDevice\":\"1\",\"systemName\":\"Windows 98\",\"type\":\"Windows_Workstation\",\"cost\":\"4.0\"}";
    @Test
    public void createDevicetoCustomer() throws Exception {
        Customer customer= new Customer(1);
        Device mockDevice = new Device(customer,"Windows 98",deviceType.Windows_Workstation);

        Mockito.when(
                deviceService.create(Mockito.anyLong(),  Mockito.any(DeviceRequest.class))).thenReturn(mockDevice);


        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/device/1")
                .accept(MediaType.APPLICATION_JSON).content(exampleDeviceJson)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.CREATED.value(), response.getStatus());
       }
    @Test
    public void deleteDevicetoCustomer() throws Exception {

      Mockito.when(
                deviceService.delete(Mockito.anyLong(), Mockito.anyLong())).thenReturn(true);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/device/1/1")
                .accept(MediaType.APPLICATION_JSON).content("Device deleted succesfully")
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }
    @Test
    public void updateDevicetoCustomer() throws Exception {
        Customer customer= new Customer(1);
         Device mockDevice = new Device(customer,"Windows 98",deviceType.Windows_Workstation);
        Mockito.when(
                deviceService.update(Mockito.anyLong(), Mockito.anyLong(),Mockito.any(DeviceRequest.class))).thenReturn(mockDevice);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/device/1/1")
                .accept(MediaType.APPLICATION_JSON).content(exampleDeviceJson)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.ACCEPTED.value(), response.getStatus());
    }
    @Test
    public void getDevicetoCustomer() throws Exception {
        Customer customer= new Customer(1);
        Device mockDevice = new Device(customer,"Windows 98",deviceType.Windows_Workstation);
        List<Device> devices= new ArrayList<>();
        devices.add(mockDevice);
        Mockito.when(
                deviceService.get(Mockito.anyLong())).thenReturn(devices);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/device/1")
                .accept(MediaType.APPLICATION_JSON).content(exampleDeviceJson)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }


}

