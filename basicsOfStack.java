import java.util.Scanner;
import java.util.Stack;

//  write a function to print all element of stack from bottom to top
// use stack to copy element from original stack
public class basicsOfStack {
    static void printAllElement(Stack<Integer> stack){
        Stack<Integer> copyStack = new Stack<>();
        while (!stack.isEmpty()){
            copyStack.push(stack.pop());
        }
        while (!copyStack.isEmpty()){
            System.out.print(copyStack.peek()+" ");
            stack.push(copyStack.pop());
        }
        System.out.println();
    }


    //  write a function to print all element of stack from bottom to top
// use array to copy element from original stack

    static void printAllElement2(Stack<Integer> stack){
        int arraySize = stack.size();
        int [] array = new int[arraySize];
            int j = 0;
        while (!stack.isEmpty()){
            array[j] = stack.pop();
            j++;
        }
        for (j = arraySize-1; j >= 0 ; j--) {
            System.out.print(array[j]+" ");
            stack.push(array[j]);
        }
        System.out.println();
    }

//    write a function to print a stack using recursion

//    static void printStackUsingRecursion(Stack<Integer> st){
//        if (st.size() == 0)return;
//        int topElement = st.pop();
//        printStackUsingRecursion(st);
//        System.out.print(topElement+" ");
//        st.push(topElement);
//    }

    //    write a function to print a stack in reverse order using recursion

    static void printReverseStackUsingRecursion(Stack<Integer> st){
        if (st.size() == 0)return;
        int topElement = st.pop();
        System.out.print(topElement+" ");
        printReverseStackUsingRecursion(st);
        st.push(topElement);
    }

//    write a function to reverse a stack element iteratively

    static void reverseStackIteratively(Stack<Integer> st){
        Stack<Integer> firstCopy = new Stack<>();
        while (!st.isEmpty()){
            firstCopy.push(st.pop());
        }
        Stack<Integer> secondCopy = new Stack<>();
        while (!firstCopy.isEmpty()){
            secondCopy.push(firstCopy.pop());
        }
        while (!secondCopy.isEmpty()){
            st.push(secondCopy.pop());
        }
    }

    //    write a function to reverse a stack element recursively

   static Stack<Integer> insertElementAtBottomRecursively(Stack<Integer> st,int top){
        if(st.isEmpty()){
            st.push(top);
            return st;
        }
        int x = st.pop();
        insertElementAtBottomRecursively(st,top);
        st.push(x);
        return st;
   }
    public static Stack<Integer> reverseStack(Stack<Integer> stack) {
                if (stack.isEmpty()) return stack;
                int top = stack.pop();
                stack = reverseStack(stack);
                stack = insertElementAtBottomRecursively(stack, top);
                return stack;
            }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> st = new Stack<>();
//        System.out.println(st.size());
//        st.push(1);
//        System.out.println(st.peek());
        for (int i = 1; i < 6; i++) {
            st.push(i);
        }
//        int x = st.pop();
//        System.out.println(st);
//        int i = 2;
//        while (i > 0){
//            System.out.println(st.pop());
//            i--;
//        }
//        System.out.println(st);
//        System.out.println(x);



//        to insert element at the bottom of st


//        Stack<Integer> copyStack = new Stack<>();
//        while (st.size() > 0){
//            copyStack.push(st.pop());
//        }
//        System.out.println(copyStack);
//        copyStack.push(6);
//        while (copyStack.size() > 0){
//            st.push(copyStack.pop());
//        }
//        System.out.println(st);


//        to insert element at the 3rd position from bottom of st

//        Stack<Integer> copyStack = new Stack<>();
//          while (st.size() > 2){
//              copyStack.push(st.pop());
//          }
//          copyStack.push(6);
//          while (copyStack.size() > 0){
//              st.push(copyStack.pop());
//          }
//        System.out.println(st);


//       write a function to print all element of stack from bottom to top
//        printAllElement(st);
//        System.out.println(st);

        //       write a function to print all element of stack from bottom to top
//        printAllElement2(st);
//        System.out.println(st);
//        printStackUsingRecursion(st);
//        printReverseStackUsingRecursion(st);
//        reverseStackIteratively(st);
//        System.out.println(st);
//        System.out.println(st);
//        System.out.println(insertElementAtBottomRecursively(st,6));
//        System.out.println(st);
//        System.out.println(reverseStack(st));

    }
}
