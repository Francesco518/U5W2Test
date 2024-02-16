package francescobuonocore.U5W2Test.repositories;

import francescobuonocore.U5W2Test.entities.Device;
import francescobuonocore.U5W2Test.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DevicesRepository extends JpaRepository<Device, Long> {
    List<Device> findByEmployee(Employee employee);
}
