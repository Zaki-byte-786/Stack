import java.util.Stack;

public class minimumStackOptimized {
    Stack<Long> st = new Stack<>();
    Long min = Long.MAX_VALUE;
    void push(int val){
        Long l = (long) val;
        if (st.isEmpty()){
            st.push(l);
            min = l;
        }
        else {
            if (l < min){
                st.push(2 * l - min);
                min = l;
            }
            else {
                st.push(l);
            }
        }
    }
    void pop(){
        if (st.isEmpty()) return;
        if (st.peek() < min){
            min = 2 * min - st.peek();
        }
        st.pop();
    }
    int top(){
        if (st.peek() < min){
            return min.intValue();
        }
        return st.peek().intValue();
    }
    int getMin(){
        return min.intValue();
        // or you can write
//        long x = min;
//        return (int) x;

    }
    void display(){
        for (long element : st){
            System.out.print(element+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        minimumStackOptimized stack = new minimumStackOptimized();
        stack.push(-1);
        stack.push(0);
        stack.push(-2);
        stack.push(-3);
        stack.push(3);
        stack.display();
        System.out.println(stack.getMin());
        stack.pop();
        stack.display();
        System.out.println(stack.getMin());
        stack.pop();
        stack.display();
        System.out.println(stack.getMin());
        stack.pop();
        stack.display();
        System.out.println(stack.getMin());
//        int x = 3;
//        Long L = (long)x;
//        long l = L;
//        System.out.println((int)l);




    }
}
