import java.util.Stack;

public class infixToPrefixSmart {
    static int precedenceOf(char ch){
        if (ch == '^')return 3;
        else if (ch == '*' || ch == '/') return 2;
        else if(ch == '+' || ch == '-') return 1;
        return 0;
    }
    public static String infixToPrefixSmartMethod(String s) {
        Stack<String> st = new Stack<>();
        Stack<Character> op = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if ((ch >= 'a' && ch <= 'z')
                    || (ch >= 'A' && ch <= 'Z')
                    || ((int) ch >= 48 && (int) ch <= 57)) {
                st.push("" + ch);
            } else if (ch == ')') {
                while (op.peek() != '(') {
                    String v2 = st.pop();
                    String v1 = st.pop();
                    st.push( op.pop() + v1 + v2);
                }
                op.pop();
            } else if (op.isEmpty() || ch == '(' || op.peek() == '(') {
                op.push(ch);
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^') {
                while (!op.isEmpty() && (precedenceOf(op.peek()) >= precedenceOf(ch))) {
                    String v2 = st.pop();
                    String v1 = st.pop();
                    st.push(op.pop() + v1 + v2);
                }
                op.push(ch);
            }
        }
        while (st.size() > 1) {
            String v2 = st.pop();
            String v1 = st.pop();
            st.push(op.pop() + v1 + v2);
        }
        return st.peek();
    }
    public static void main(String[] args) {
        System.out.println(infixToPrefixSmartMethod("(a-(b^c))+(d)"));
        System.out.println(infixToPrefixSmartMethod("4+(5*2^3)-3"));
    }
}
