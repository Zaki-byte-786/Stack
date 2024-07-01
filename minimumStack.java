import java.util.Stack;

public class minimumStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> stackHelper = new Stack<>();
    public void push(int val) {
        stack.push(val);
        // Always push the current minimum to the stackHelper
        if (stackHelper.isEmpty() || val <= stackHelper.peek()) {
            stackHelper.push(val);
        } else {
            stackHelper.push(stackHelper.peek());
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
            stackHelper.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return stackHelper.peek();
    }
    void display(){
        for (long element : stack){
            System.out.print(element+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        minimumStack stack1 = new minimumStack();
        stack1.push(3);
        stack1.push(2);
        stack1.push(1);
        stack1.push(5);
        stack1.push(4);
        stack1.display();
        System.out.println(stack1.getMin());
        stack1.pop();
        stack1.display();

        stack1.pop();
    }
}
