import java.util.Stack;

public class postfixEvaluation {
    static int postfixCalculation(String s){
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int ascii = (int)ch;
            if (ascii >= 48 && ascii <= 57){
                st.push(ascii - 48);
            }
            else {
                int v2 = st.pop();
                int v1 = st.pop();
                if (ch == '+')st.push(v1 + v2);
                if (ch == '-')st.push(v1 - v2);
                if (ch == '*')st.push(v1 * v2);
                if (ch == '/')st.push(v1 / v2);
            }
        }
        return st.peek();
    }
    public static void main(String[] args) {
        System.out.println(postfixCalculation("95-3+4*6/"));
    }
}
