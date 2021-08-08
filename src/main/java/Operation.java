/**
 * Enum providing all available operations
 */
public enum Operation {
    ADD("add"),
    SUBTRACT("subtract"),
    MULTIPLY("multiply"),
    DIVIDE("divide"),
    POWER("power"),
    APPLY("apply");

    private final String operation;

    Operation(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return this.operation;
    }

    public static Operation fromString(String text) {
        for (Operation b : Operation.values()) {
            if (b.operation.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }
}
