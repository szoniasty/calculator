import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Calculator {

    private static final FileReaderHelper fileReaderHelper = new FileReaderHelper();
    private static final InstructionReader instructionReader = new InstructionReader();
    private static final CalculatorEngine calculatorEngine = new CalculatorEngine();

    public static void main(String[] args) throws Exception {
        File file = new File(args[0]);
        Double baseValue;

        String lastLine = fileReaderHelper.getLastLine(file);
        if (!instructionReader.isValidApplyInstruction(lastLine)){
            System.out.println("Provided file does not contain proper last line.");
            return;
        }

        baseValue = instructionReader.getValue(lastLine);

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (instructionReader.isValidInstruction(line) && !instructionReader.isValidApplyInstruction(line)) {
                    baseValue = calculatorEngine.calculate(baseValue,
                            instructionReader.getOperation(line), instructionReader.getValue(line));
                }
            }
        }

        System.out.printf("Result is: %.0f\n", baseValue);
    }
}
