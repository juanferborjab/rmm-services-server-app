package com.ninjarmm.app.service;


import com.ninjarmm.app.controller.request.DeviceRequest;
import com.ninjarmm.app.entity.Customer;
import com.ninjarmm.app.entity.device.Device;
import com.ninjarmm.app.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    @Autowired
    private CustomerService customerService;

    public Device create(Long idCustomer, DeviceRequest deviceRequest) {
        customerService.validateCustomerExist(idCustomer);
        Customer customer = customerService.findById(idCustomer);
        Device device = new Device(customer, deviceRequest.systemName, deviceRequest.deviceType);
        return deviceRepository.save(device);
    }

    public List<Device> get(Long idCustomer) {
        customerService.validateCustomerExist(idCustomer);
        return deviceRepository.findByIdCustomer(idCustomer);
    }

    public Device update(Long idCustomer, Long idDevice, DeviceRequest deviceRequest) {
        customerService.validateCustomerExist(idCustomer);
        Customer customer = customerService.findById(idCustomer);
        Device device = deviceRepository.findById(idDevice).orElseThrow(() -> new RuntimeException("Device not found."));
        device.setType(deviceRequest.deviceType);
        device.setSystemName(deviceRequest.systemName);
        return deviceRepository.save(device);
    }

    public boolean delete(Long idCustomer, Long idDevice) {
        customerService.validateCustomerExist(idCustomer);
        Device device = deviceRepository.findById(idDevice).orElseThrow(() -> new RuntimeException("Device not found."));
        try {
            deviceRepository.delete(device);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
