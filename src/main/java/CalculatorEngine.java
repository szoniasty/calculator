public class CalculatorEngine {

    public Double calculate(Double baseValue, Operation operation, Double value) {
        switch (operation) {
            case ADD:
                return baseValue + value;
            case SUBTRACT:
                return baseValue - value;
            case MULTIPLY:
                return baseValue * value;
            case DIVIDE:
                return baseValue / value;
            case POWER:
                return Math.pow(baseValue, value);
            default:
                return baseValue;
        }
    }
}
