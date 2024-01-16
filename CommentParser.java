public class CommentParser {
    
    public CommentParser() {
        
    }

    public static String removeComments(String input) {
        String result = "";
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '/' && input.charAt(i + 1) == '/') {
                break;
            }
            result += input.charAt(i);
        }
        return result;
    }
}
