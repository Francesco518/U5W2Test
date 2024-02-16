package francescobuonocore.U5W2Test.exceptions;

public class NotFoundExceptions extends RuntimeException {
    public NotFoundExceptions (long id) {
        super(id + " has not been found");
    }
}
