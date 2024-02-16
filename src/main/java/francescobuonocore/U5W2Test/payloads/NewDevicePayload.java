package francescobuonocore.U5W2Test.payloads;

import lombok.Getter;

@Getter
public class NewDevicePayload {
    private long employeeId;
    private String type;
    private String status;
}
