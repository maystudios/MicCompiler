public class AdresseParser {
    
    public AdresseParser() {
        
    }

    public static String getNextAdresse(int input) {
        return lib.IntToBinary(input, 9);
    }

    public static String checkForGoto(String line) {
        if (line.contains("goto")) {
            String afterGoto = line.substring(line.indexOf("goto") + 5);
            int gotoIndex = Integer.parseInt(lib.replaceAllLeftAndRightSpaces(afterGoto));
            return lib.IntToBinary(gotoIndex, 9);
        }
        return null;
    }
}
