/**
 * Helper class that parses Strings representing file lines
 */
public class InstructionReader {

    public Operation getOperation(String line) {
        return Operation.fromString(line.split("\\s+")[0]);
    }

    public Double getValue(String line) {
        try {
            return Double.parseDouble(line.split("\\s+")[1]);
        } catch (NumberFormatException nfe) {
            return null;
        }
    }

    public boolean isValidInstruction(String instruction) {
        return instruction != null && getValue(instruction) != null && getOperation(instruction) != null;
    }

    public boolean isValidApplyInstruction(String instruction) {
        return instruction != null && isValidInstruction(instruction) &&
                getOperation(instruction).equals(Operation.APPLY);
    }
}
