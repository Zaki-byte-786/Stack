import java.util.Stack;

public class prefixEvaluation {
    static int prefixCalculation(String s){
        Stack<Integer> st = new Stack<>();
        for (int i = s.length() - 1; i >= 0 ; i--) {
            char ch = s.charAt(i);
            int ascii = (int)ch;
            if (ascii >= 48 && ascii <= 57){
                st.push(ascii - 48);
            }
            else {
                int v1 = st.pop();
                int v2 = st.pop();
                if (ch == '+')st.push(v1 + v2);
                if (ch == '-')st.push(v1 - v2);
                if (ch == '*')st.push(v1 * v2);
                if (ch == '/')st.push(v1 / v2);
            }
        }
        return st.peek();
    }
    public static void main(String[] args) {
        System.out.println(prefixCalculation("/**9+5346"));
    }
}
