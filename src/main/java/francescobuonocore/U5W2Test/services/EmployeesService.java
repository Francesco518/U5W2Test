package francescobuonocore.U5W2Test.services;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import francescobuonocore.U5W2Test.entities.Employee;
import francescobuonocore.U5W2Test.exceptions.BadRequestException;
import francescobuonocore.U5W2Test.exceptions.NotFoundExceptions;
import francescobuonocore.U5W2Test.payloads.NewEmployeeDTO;
import francescobuonocore.U5W2Test.repositories.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class EmployeesService {

    @Autowired
    private EmployeesRepository employeesRepository;

    public Page<Employee> getEmployees(int page, int size, String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return employeesRepository.findAll(pageable);
    }

    public Employee save(NewEmployeeDTO paylaod) {
        employeesRepository.findByEmail(paylaod.email()).ifPresent(employee -> {
            throw new BadRequestException("The email " + employee.getEmail() + " has already been used");
        });
        Employee newEmployee = new Employee(paylaod.username(), paylaod.name(), paylaod.surname(), paylaod.email());
        return employeesRepository.save(newEmployee);
    }
    public Employee findById(long id) {
        return employeesRepository.findById(id).orElseThrow(() -> new NotFoundExceptions(id));
    }
    public Employee findAndUpdate(long id, Employee newEmployee) {
        Employee found = this.findById(id);
        found.setUsername(newEmployee.getUsername());
        found.setName(newEmployee.getName());
        found.setSurname(newEmployee.getSurname());
        found.setEmail(newEmployee.getEmail());
        return this.employeesRepository.save(found);
    }

    public void findAndDelete(long id) {
        Employee found = this.findById(id);
        this.employeesRepository.delete(found);
    }


}
