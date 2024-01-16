import File.FileReader;
import File.FileWriter;

public class MicCompiler {

    private RegisterParser registerParser = new RegisterParser();
    private AluParser aluParser = new AluParser();
    private MemoryParser memoryParser = new MemoryParser();
    private AdresseParser adresseParser = new AdresseParser();
    private FileReader fileReader = new FileReader();
    private FileWriter fileWriter = new FileWriter();
    private lib lib = new lib();

    public MicCompiler() {

    }

    public String compileLine(int lineNumber, String line) {
        return adresseParser.getNextAdresse(lineNumber) + " " + aluParser.getAluInstruction(line)[0] + " "
                + registerParser.getSetRegisterBinary(line) + " " + memoryParser.getMemoryInstructionBinary(line) + " "
                + registerParser.getUsedRegisterBinary(line);
    }

    public String[][] compileFile(String path) {
        String[] lines = fileReader.getLinesMayFile(path);
        String[] code = new String[lines.length];
        String[][] result = new String[2][lines.length];
        for (int i = 0; i < lines.length; i++) {
            code[i] = compileLine(i + 1, lines[i]);
        }

        result[0] = lines;
        result[1] = code;
        return result;
    }

    public void compileFileAndWrite(String path) {
        String[][] lines = compileFile(path);
        fileWriter.createFileInPackageAndWriteLines(lines[1], path);
    }

    public static void main(String[] args) {
        MicCompiler micCompiler = new MicCompiler();

        String file = "test.may";
        String[][] code = micCompiler.compileFile(file);
        for (int i = 0; i < code[0].length; i++) {
            System.out.println(code[0][i] + " -> " + code[1][i]);
        }
        micCompiler.compileFileAndWrite(file);
    }
}