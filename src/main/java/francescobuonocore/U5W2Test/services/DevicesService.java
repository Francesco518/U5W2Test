package francescobuonocore.U5W2Test.services;

import francescobuonocore.U5W2Test.entities.Device;
import francescobuonocore.U5W2Test.entities.Employee;
import francescobuonocore.U5W2Test.exceptions.NotFoundExceptions;
import francescobuonocore.U5W2Test.payloads.NewDevicePayload;
import francescobuonocore.U5W2Test.repositories.DevicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class DevicesService {

    @Autowired
    private DevicesRepository devicesRepository;
    @Autowired
    private EmployeesService employeesService;

    public Device save(NewDevicePayload body) {
        Employee employee = employeesService.findById(body.getEmployeeId());
        Device device = new Device();
        device.setType(body.getType());
        device.setStatus(body.getStatus());
        device.setEmployee(employee);
        return this.devicesRepository.save(device);
    }
    public List<Device> getDevices() {
        return this.devicesRepository.findAll();
    }
    public Device findById(long id) {
        return this.devicesRepository.findById(id).orElseThrow(() -> new NotFoundExceptions(id));
    }
    public void findAndDelete(long id) {
        Device found = this.findById(id);
        this.devicesRepository.delete(found);
    }
    public Device findAndUpdate(long id, NewDevicePayload newDevice) {
        Device found = this.findById(id);
        found.setType(newDevice.getType());
        found.setStatus(newDevice.getStatus());

        if (found.getEmployee().getId()!= newDevice.getEmployeeId()) {
            Employee brandNewDevice = employeesService.findById(newDevice.getEmployeeId());
            found.setEmployee(brandNewDevice);
        }
        return devicesRepository.save(found);
    }
    public List<Device> findByEmployee(int employeeId) {
        Employee employee = employeesService.findById(employeeId);
        return devicesRepository.findByEmployee(employee);
    }
}
