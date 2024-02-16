package francescobuonocore.U5W2Test.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "devices")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String type;

    private String status;
    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;
}
