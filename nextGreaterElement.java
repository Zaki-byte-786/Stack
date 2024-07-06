import java.util.Arrays;
import java.util.Stack;

public class nextGreaterElement {
    static int[] nextGreaterElementMethod(int[] array){
        int n = array.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n-1; i >= 0 ; i--) {
            while (!st.isEmpty() && array[i] >= st.peek()){
                    st.pop();
                }
            if (st.isEmpty()){
                    ans[i] = -1;
                }
            else {
                    ans[i] = st.peek();
                }
            st.push(array[i]);
        }
        return ans;
    }
    public static void main(String[] args) {
    int [] array = {4,12,5,3,1,2,5,3,1,2,4,6};

        System.out.println(Arrays.toString(nextGreaterElementMethod(array)));
    }
}
