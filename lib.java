public class lib {
    
    public lib() {
        
    }

    public static String IntToBinary(int input) {
        String binary = Integer.toBinaryString(input);
        while (binary.length() < 16) {
            binary = "0" + binary;
        }
        return binary;
    }   

    public static String IntToBinary(int input, int length) {
        String binary = Integer.toBinaryString(input);
        while (binary.length() < length) {
            binary = "0" + binary;
        }
        return binary;
    }

    public static String OrBinaryStrings(String input1, String input2) {
        String result = "";
        for (int i = 0; i < input1.length(); i++) {
            if (input1.charAt(i) == '1' || input2.charAt(i) == '1') {
                result += "1";
            } else {
                result += "0";
            }
        }
        return result;
    }
}
