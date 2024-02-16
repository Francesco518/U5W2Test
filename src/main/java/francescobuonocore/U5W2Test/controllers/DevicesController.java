package francescobuonocore.U5W2Test.controllers;

import francescobuonocore.U5W2Test.entities.Device;
import francescobuonocore.U5W2Test.payloads.NewDevicePayload;
import francescobuonocore.U5W2Test.services.DevicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/devices")
public class DevicesController {
    @Autowired
    DevicesService devicesService;

    @GetMapping
    public List<Device> getDevices(@RequestParam(required = false) Integer employeeId) {
        if (employeeId != null) return devicesService.findByEmployee(employeeId);
        else {
            return devicesService.getDevices();
        }
    }
    @GetMapping("/{deviceId}")
    public Device findById(@PathVariable long deviceId) {
        return devicesService.findById(deviceId);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Device saveDevices(@RequestBody NewDevicePayload newDevice) {
        return devicesService.save(newDevice);
    }
    @PutMapping("/{deviceId}")
    public Device findAndUpdate(@PathVariable long deviceId,@RequestBody NewDevicePayload newDevice) {
        return devicesService.findAndUpdate(deviceId, newDevice);
    }
    @DeleteMapping("/{deviceId}")
    public void findAndDelete(@PathVariable long deviceId) {
        this.devicesService.findAndDelete(deviceId);
    }
}
