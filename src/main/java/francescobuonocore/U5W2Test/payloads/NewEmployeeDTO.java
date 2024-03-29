package francescobuonocore.U5W2Test.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record NewEmployeeDTO(
        @NotEmpty(message = "The username is mandatory")
        String username,
        @NotEmpty(message = "The name is mandatory")
        String name,
        @NotEmpty(message = "The surname is mandatory")
        String surname,
        @Email(message = "You need to insert a proper email")
        String email
) {
}
