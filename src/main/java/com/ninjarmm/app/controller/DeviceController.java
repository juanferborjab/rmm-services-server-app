package com.ninjarmm.app.controller;

import com.ninjarmm.app.controller.request.DeviceRequest;
import com.ninjarmm.app.entity.device.Device;
import com.ninjarmm.app.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/device")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

     @PostMapping(value = "/{idCustomer}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Device> createDevice(
            @PathVariable(value = "idCustomer") long idCustomer,
            @Valid @RequestBody DeviceRequest deviceRequest) {
        return new ResponseEntity<>(deviceService.create(idCustomer, deviceRequest), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{idCustomer}/{idDevice}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> removeDeviceFromCustomer(
            @PathVariable(value = "idCustomer") long idCustomer,
            @PathVariable(value = "idDevice") long idDevice
            ) {
        if (deviceService.delete(idCustomer, idDevice)) {
            return new ResponseEntity<>("Device deleted succesfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Device not deleted!", HttpStatus.CONFLICT);
        }
    }

    @PutMapping (value = "/{idCustomer}/{idDevice}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<Device> updateDevice(
            @PathVariable(value = "idCustomer") long idCustomer,
            @PathVariable(value = "idDevice") long idDevice,
            @Valid @RequestBody DeviceRequest deviceRequest) {
        return new ResponseEntity<>(deviceService.update(idCustomer,idDevice, deviceRequest), HttpStatus.ACCEPTED);
    }

    @GetMapping (value = "/{idCustomer}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Device>> getDevice(
            @PathVariable(value = "idCustomer") long idCustomer)
          {
        return new ResponseEntity<>(deviceService.get(idCustomer), HttpStatus.OK);
    }

}
