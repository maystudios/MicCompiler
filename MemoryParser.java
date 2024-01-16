import java.util.HashMap;
import java.util.Map;

public class MemoryParser {

    public MemoryParser() {
        // TODO Auto-generated constructor stub
    }

    public static final Map<String, Integer> MemoryInstruction = new HashMap<>();

    static {
        MemoryInstruction.put("fetch", 1);
        MemoryInstruction.put("rd", 2);
        MemoryInstruction.put("wr", 3);
    }

    public String getMemoryInstructionBinary(String input) {
        for (String key : MemoryInstruction.keySet()) {
            if (input.contains(key)) {
                return lib.IntToBinary(MemoryInstruction.get(key), 2);
            }
        }
        return lib.IntToBinary(0, 2);
    }
}
