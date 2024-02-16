package francescobuonocore.U5W2Test.repositories;

import francescobuonocore.U5W2Test.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface EmployeesRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByEmail(String email);
}

