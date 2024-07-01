import java.util.Stack;

public class postfixToPrefix {
    static String postfixToPrefixConversion(String s){
        Stack<String> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int ascii = (int) ch;
            if (ascii >= 48 && ascii <= 57){
                st.push(""+ch);
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
        System.out.println(postfixToPrefixConversion("953+*4*6/"));
    }
}
