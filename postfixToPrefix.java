import java.util.Stack;

public class postfixToPrefix {
    static String postfixToPrefixConversion(String s){
        Stack<String> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if ((ch >= 'a' && ch <= 'z')
                    || (ch >= 'A' && ch <= 'Z')
                    || ((int) ch >= 48 && (int) ch <= 57)) {
                st.push("" + ch);
            }
            else {
                String v2 = st.pop();
                String v1 = st.pop();
                st.push( ch + v1 + v2);
            }
        }
        return st.peek();
    }
    public static void main(String[] args) {
        System.out.println(postfixToPrefixConversion("abc^-d+"));
    }
}
