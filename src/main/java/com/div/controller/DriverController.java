package com.div.controller;

import com.div.dto.DriverDto;
import com.div.service.DriverService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/driver")
public class DriverController {
    private  final DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @PostMapping
    public DriverDto creatDriver(@RequestBody DriverDto driverDto){
        return driverService.creatDriver(driverDto);
    }
    @GetMapping
    public List<DriverDto> getAllDriver(){
     return    driverService.getAllDriver();
    }
    @GetMapping("/{id}")
    public DriverDto getDriverById(@PathVariable Long id){
        return driverService.getDriverById(id);
    }
    @PutMapping("/{id}")
    public  void  updateDriver(@PathVariable Long id,@RequestBody DriverDto driverDto){
        driverService.updateDriver(id,driverDto);
    }
    @DeleteMapping("/{id}")
    public void deleteDriver(@PathVariable Long id){
        driverService.deleteDriver(id);
    }
}
