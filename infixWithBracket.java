import java.util.Stack;
public class infixWithBracket {
    static int precedenceOf(char ch){
        if (ch == '^')return 3;
        else if (ch == '*' || ch == '/') return 2;
        else if(ch == '+' || ch == '-') return 1;
        return 0;
    }
    static int infixEvaluation(String s){
        Stack<Integer> operand = new Stack<>();
        Stack<Character> operator = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9'){
                operand.push((int)ch - 48);
            }
            else if (ch == ')') {
                while (operator.peek() != '('){
                    int v2 = operand.pop();
                    int v1 = operand.pop();
                    if (operator.peek() == '+')operand.push(v1 + v2);
                    if (operator.peek() == '-')operand.push(v1 - v2);
                    if (operator.peek() == '*')operand.push(v1 * v2);
                    if (operator.peek() == '/')operand.push(v1 / v2);
                    if (operator.peek() == '^')operand.push(v1 ^ v2);
                    operator.pop();
                }
                operator.pop();
            }
            else if (operator.isEmpty() || ch == '(') operator.push(ch);
            else { //      +,-,*,/,^
                while (!operator.isEmpty() && precedenceOf(operator.peek()) >= precedenceOf(ch)){
                    int v2 = operand.pop();
                    int v1 = operand.pop();
                    if (operator.peek() == '+')operand.push(v1 + v2);
                    if (operator.peek() == '-')operand.push(v1 - v2);
                    if (operator.peek() == '*')operand.push(v1 * v2);
                    if (operator.peek() == '/')operand.push(v1 / v2);
                    if (operator.peek() == '^')operand.push(v1 ^ v2);
                    operator.pop();
                }
                operator.push(ch);
            }
        }
        while (operand.size() > 1){
            int v2 = operand.pop();
            int v1 = operand.pop();
            if (operator.peek() == '+')operand.push(v1 + v2);
            if (operator.peek() == '-')operand.push(v1 - v2);
            if (operator.peek() == '*')operand.push(v1 * v2);
            if (operator.peek() == '/')operand.push(v1 / v2);
            operator.pop();
        }
        return operand.peek();
    }
    public static void main(String[] args) {
        String s = "4+5*3^2-6";
        System.out.println(infixEvaluation(s));

    }
}
