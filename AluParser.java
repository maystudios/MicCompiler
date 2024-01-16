
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AluParser {

    private static final Map<String, String> operationToSignals = new HashMap<>();

    static {
        operationToSignals.put("A AND B", "011000");
        operationToSignals.put("A OR B", "100000");
        operationToSignals.put("A + B", "101000");
        operationToSignals.put("A + B + 1", "110000");
        operationToSignals.put("A + 1", "111000");
        operationToSignals.put("B + 1", "101010");
        operationToSignals.put("B - A", "111010");
        operationToSignals.put("B - 1", "110010");
        operationToSignals.put("A", "001000");
        operationToSignals.put("B", "010000");
        operationToSignals.put("-A", "110011");
        operationToSignals.put("-1", "111011");
        operationToSignals.put("1", "111111");
        operationToSignals.put("0", "110101");
    }

    public AluParser() {

    }

    public static Map<String, Set<String>> parseAlu(String input) {
        String[] parts = input.split(";"); // Split by semicolon to separate instructions
        Set<String> setAlu = new HashSet<>();
        Set<String> usedAlu = new HashSet<>();

        for (String part : parts) {
            String[] assignments = part.split("="); // Split by "=" to separate assignments
            for (int i = 0; i < assignments.length - 1; i++) {
                // Process for set registers
                String setPart = assignments[i].trim();
                if (RegisterParser.C_BUS_MAP.containsKey(setPart)) {
                    setAlu.add(setPart);
                }
            }

            // Process for used registers
            String[] tokens = assignments[assignments.length - 1].split("[\\s+-]+"); // Split by whitespace, plus, and
                                                                                     // minus
            for (String token : tokens) {
                if (RegisterParser.B_BUS_MAP.containsKey(token)) {
                    usedAlu.add(token);
                }
            }
        }

        Map<String, Set<String>> result = new HashMap<>();
        result.put("Set Alu", setAlu);
        result.put("Used Alu", usedAlu);
        return result;
    }

    public String[] getAluInstruction(String input) {
        RegisterParser registerParser = new RegisterParser();
        Map<String, Set<String>> result = registerParser.parseRegisters(input);

        Set<String> setRegisters = result.get("Set");
        Set<String> usedRegisters = result.get("Used");

        for (String setRegister : setRegisters) {
            input = input.replaceFirst(setRegister, "C");
        }

        for (String usedRegister : usedRegisters) {
            input = input.replaceFirst(usedRegister, "B");
        }

        String[] res = new String[2];

        System.out.println(input);

        String operatingCode = input.substring(input.lastIndexOf("=") + 1,
                (input.indexOf(";") == -1) ? input.length() : input.indexOf(";"));

        for (String operation : operationToSignals.keySet()) {
            if (replaceAllLeftAndRightSpaces(operatingCode).equals(operation)) {
                res[0] = operationToSignals.get(operation);
                res[1] = operation;
                break;
            }
        }

        return res;
    }

    private String replaceAllLeftAndRightSpaces(String input) {
        return input.replaceAll("^\\s+", "").replaceAll("\\s+$", "");
    }

    public static void main(String[] args) {
        String input1 = "MAR = -1;";
        AluParser aluParser = new AluParser();
        String[] res = aluParser.getAluInstruction(input1);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}
