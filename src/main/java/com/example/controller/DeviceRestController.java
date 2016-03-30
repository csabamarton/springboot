package com.example.controller;

import com.example.model.Device;
import com.example.rest.DeviceRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/rest")
public class DeviceRestController {
    protected static Logger logger = Logger.getLogger(DeviceRestController.class);

    private final DeviceRepository deviceRepository;

    @RequestMapping(value = "/device/add", method = RequestMethod.POST, headers="Accept=application/json")
    ResponseEntity<String> add(@RequestBody Device input) {
        logger.info("Add new device or update the lastview field");

        input.setRegDate(new Date());
        deviceRepository.save(input);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @RequestMapping(value = "/deviceid/{id}", method=RequestMethod.GET, headers="Accept=application/json")
    public Device getDevice(@PathVariable int id) {
        Device device = deviceRepository.findOne(1L);

        return device;
    }

    @Autowired
    DeviceRestController(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

}
