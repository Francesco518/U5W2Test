package francescobuonocore.U5W2Test.controllers;

import francescobuonocore.U5W2Test.entities.Employee;
import francescobuonocore.U5W2Test.payloads.NewEmployeeDTO;
import francescobuonocore.U5W2Test.services.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeesController {
    @Autowired
    EmployeesService employeesService;

    @GetMapping
    public Page<Employee> getEmployees(@RequestParam(defaultValue = "0") int page,
                                       @RequestParam(defaultValue = "10") int size,
                                       @RequestParam(defaultValue = "id") String sortBy) {
        return employeesService.getEmployees(page, size, sortBy);
    }
    @GetMapping("/{employeeId}")
    public Employee findById(@PathVariable int employeeId) {
        return employeesService.findById(employeeId);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee saveEmployee(@RequestBody NewEmployeeDTO newEmployeeDTO) throws Exception {
        return employeesService.save(newEmployeeDTO);
    }
    @PutMapping("/{employeeId}")
    public Employee findAndUpdate(@PathVariable int employeeId, @RequestBody Employee newEmployee) {
        return employeesService.findAndUpdate(employeeId, newEmployee);
    }
    @DeleteMapping("/{employeeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findAndDelete(@PathVariable int employeeId) {
        this.employeesService.findAndDelete(employeeId);
    }
}
