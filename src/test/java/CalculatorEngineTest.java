import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorEngineTest {

    @ParameterizedTest
    @CsvSource(delimiter = ' ', value = {
            "0 ADD 1 1",
            "1 ADD 1 2",
            "2 DIVIDE 2 1",
            "9 DIVIDE 2 4.5",
            "1 DIVIDE 0 Infinity",
            "1 MULTIPLY 1 1",
            "0 MULTIPLY 1 0",
            "2 SUBTRACT 1 1",
            "1 SUBTRACT 0 1",
            "2 POWER 2 4",
            "1 POWER 100 1",
            "1 APPLY 99 1",
            "0 APPLY 99 0"
    })
    public void shouldCalculate(Double baseValue, Operation operation, Double value, Double expectedResult) {
        // given
        CalculatorEngine calculatorEngine = new CalculatorEngine();
        // when
        Double result = calculatorEngine.calculate(baseValue, operation, value);
        // then
        assertEquals(expectedResult, result);
    }
}
