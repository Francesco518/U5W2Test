package francescobuonocore.U5W2Test.payloads;

import jakarta.validation.constraints.NotEmpty;

public record NewDeviceDTO(
        @NotEmpty(message = "The type is mandatory")
        String type,
        @NotEmpty(message = "The status is mandatory")
        String status
) {
}
