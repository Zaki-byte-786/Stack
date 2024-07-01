import java.util.Stack;

public class infix {

   static int infixEvaluation(String s){
        Stack<Integer> operand = new Stack<>();
        Stack<Character> operator = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int ascii = (int) ch;
            if (ascii >= 48 && ascii <= 57)operand.push(ascii-48);
            else if (operator.isEmpty()) operator.push(ch);
            else{
                if (ch == '+' || ch == '-'){
                    int v2 = operand.pop();
                    int v1 = operand.pop();
                    if (operator.peek() == '+')operand.push(v1 + v2);
                    if (operator.peek() == '-')operand.push(v1 - v2);
                    if (operator.peek() == '*')operand.push(v1 * v2);
                    if (operator.peek() == '/')operand.push(v1 / v2);
                    operator.pop();
                    operator.push(ch);
                }
                else if (ch == '/' || ch == '*') {
                    if (operator.peek() == '/' || operator.peek() == '*'){
                        int v2 = operand.pop();
                        int v1 = operand.pop();
                        if (operator.peek() == '*')operand.push(v1 * v2);
                        if (operator.peek() == '/')operand.push(v1 / v2);
                        operator.pop();
                        operator.push(ch);
                    }
                    else {
                        operator.push(ch);
                    }

                }
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
       String s = "9-5+3*4/6";
        System.out.println(infixEvaluation(s));
    }
}
