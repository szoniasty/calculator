import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import static org.assertj.core.api.Assertions.*;

public class InstructionReaderTest {

    private final InstructionReader instructionReader = new InstructionReader();

    @ParameterizedTest
    @CsvSource(delimiter = ',', value = {
            "apply    9, APPLY",
            "add 2, ADD",
            "subtract 1, SUBTRACT",
            "multiply       3, MULTIPLY",
            "divide 2, DIVIDE"
    })
    public void testGetOperation(String line, Operation expectedResult) {
        assertThat(instructionReader.getOperation(line)).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource(delimiter = ',', value = {
            "apply    9, 9",
            "add 2, 2",
            "subtract 1, 1",
            "multiply       3, 3",
            "divide 0.001, 0.001",
            "divide XXX, "
    })
    public void testGetValue(String line, Double expectedResult) {
        assertThat(instructionReader.getValue(line)).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource(delimiter = ',', value = {
            "apply 9, true",
            "add 2, true",
            "subtract 1, true",
            "multiply 3, true",
            "divide 2, true",
            "divide XXX, false",
            "XXX 1, false",
            ", false"
    })
    public void testIsValidInstruction(String line, boolean expectedResult) {
        assertThat(instructionReader.isValidInstruction(line)).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource(delimiter = ',', value = {
            "apply 9, true",
            "add 2, false",
            "subtract 1, false",
            "multiply 3, false",
            "divide 2, false",
            "divide XXX, false",
            "XXX 1, false",
            ", false"
    })
    public void testIsValidApplyInstruction(String line, boolean expectedResult) {
        assertThat(instructionReader.isValidApplyInstruction(line)).isEqualTo(expectedResult);
    }
}
