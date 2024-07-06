import java.util.Arrays;
import java.util.Stack;

public class nextGreaterElementCircular {
    static int[] nextGreaterElementCircularMethod(int[] array){
        int n = array.length;
        int [] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        ans[n-1] = -1;
        st.push(array[n-1]);
        for (int i = 2*n-2; i >= 0 ; i--) {
            if (array[i % n] < st.peek()){
                ans[i % n] = st.peek();
                st.push(array[i % n]);
            }
            else {
                while (!st.isEmpty() && array[i % n] >= st.peek()){
                    st.pop();
                }
                if (st.isEmpty()){
                    ans[i % n] = -1;
                    st.push(array[i % n]);
                }
                else {
                    ans[i % n] = st.peek();
                    st.push(array[i % n]);
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int [] array = {4,12,5,3,1,2,5,3,1,2,4,6};

        System.out.println(Arrays.toString(nextGreaterElementCircularMethod(array)));
    }
}
