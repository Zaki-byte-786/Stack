import java.util.Stack;

public class balancedBracket {
    static boolean balancedBracketCheck(String str){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char strChar = str.charAt(i);
            if (strChar == '(' || strChar == '{' || strChar == '['){
                stack.push(strChar);
            }
            else { // ')' , '}' , ']'
                if (stack.isEmpty())return false;
                char stackTop = stack.peek();
                if((stackTop == '(' && strChar == ')')
                        || (stackTop == '{' && strChar == '}')
                        || stackTop == '[' && strChar == ']'){
                    stack.pop();
                }
                else return false;
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        String s = "[(])";
        System.out.println(balancedBracketCheck(s));
    }
}
