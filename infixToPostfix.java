import java.util.Stack;

public class infixToPostfix {
    static String infixToPostfixEvaluate(String s){
        Stack<String> num = new Stack<>();
        Stack<Character> op = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if ((int) ch >= 48 && (int) ch <= 57){
                num.push(""+ch);
            }
            else if (op.isEmpty() || ch == '(' || op.peek() == '(') {
                op.push(ch);
            }
            else if (ch == ')') {
                while (op.peek() != '('){
                    String v2 = num.pop();
                    String v1 = num.pop();
                    char o = op.pop();
                    num.push(v1 + v2 + o);
                }
                op.pop();
            }
            else {
                if (ch == '+' || ch == '-'){
                    String v2 = num.pop();
                    String v1 = num.pop();
                    char o = op.pop();
                    num.push(v1 + v2 + o);
                    op.push(ch);
                }
                else if (ch == '*' || ch == '/') {
                    if (op.peek() == '+' || op.peek() == '-'){
                        op.push(ch);
                    }
                    else {
                        String v2 = num.pop();
                        String v1 = num.pop();
                        char o = op.pop();
                        num.push(v1 + v2 + o);
                        op.push(ch);
                    }
                }
            }
        }
        while (num.size() > 1){
            String v2 = num.pop();
            String v1 = num.pop();
            char o = op.pop();
            num.push(v1 + v2 + o);
        }
        return num.peek();
    }
    public static void main(String[] args) {
        System.out.println(infixToPostfixEvaluate("9*(5+3)*4/6"));
    }
}
