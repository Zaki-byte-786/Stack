import java.util.Arrays;
import java.util.Stack;

public class stockSpanProblem {
    static int[] stockSpanProblemBrute(int[] array){
        int n = array.length;
        int[] spanArray = new int[n];
        spanArray[0] = 1;
        for (int i = 1; i < n; i++) {
            spanArray[i] = 1;
            for (int j = i-1; j >= 0; j--) {
                if (array[j] > array[i])break;
                spanArray[i]++;
            }
        }
        return spanArray;
    }
    static int[] stockSpanProblemOptimum(int[] array){
        int n = array.length;
        Stack<Integer> st = new Stack<>();
        int [] span = new int[n];
        span[0] = 1;
        st.push(0);
        for (int i = 1; i < n; i++) {
            while (!st.isEmpty() && array[i] >= array[st.peek()])st.pop();
            if (st.isEmpty())span[i] = i+1;
            else {
                span[i] = i-st.peek();
            }
            st.push(i);
        }
        return span;
    }
    public static void main(String[] args) {
int [] array = {50,40,30,20,60,55,75,70,90};
        System.out.println(Arrays.toString(stockSpanProblemBrute(array)));
        System.out.println(Arrays.toString(stockSpanProblemOptimum(array)));
    }
}
