import java.util.Arrays;
import java.util.Stack;

public class largestRectangleInHistogram {
    static int largestRectangleInHistogramBrute(int[] array){
        int left , right,area;
        int maxArea = 0;
        int n = array.length;
        for (int i = 0; i < n; i++) {
            left = i;
            right = i;
            while (left >= 0 && array[left] >= array[i])left--;
            while (right <= n-1 && array[right] >= array[i])right++;
            area = (right - left - 1) * array[i];
            if (maxArea < area)maxArea = area;
        }
        return maxArea;
    }
    static int largestRectangleInHistogramBetter(int[] array){
        int area,maxArea = 0;
        int n = array.length;
        int[] nse = new int[n];
        int[] pse = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n-1; i >= 0 ; i--) {
            while (!st.isEmpty() && array[i] <= array[st.peek()]) st.pop();
            if (st.isEmpty()) nse[i] = n;
            else nse[i] = st.peek();
            st.push(i);
        }
        while (!st.isEmpty())st.pop();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && array[i] <= array[st.peek()])st.pop();
            if (st.isEmpty())pse[i] = -1;
            else pse[i] = st.peek();
            st.push(i);
        }
        for (int i = 0; i < n; i++) {
            area = (nse[i] - pse[i] - 1) * array[i];
            if (maxArea < area)maxArea = area;
        }
        return maxArea;
    }
    static int largestRectangleInHistogramOptimal(int[] array){
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int n = array.length,area,maxArea = 0,i;
        for ( i = 0; i < n; i++) {
            while (st.peek() != -1 && array[i] <= array[st.peek()]){
                area = array[st.pop()] * (i - st.peek() - 1);
                maxArea = Integer.max(area,maxArea);
            }
             st.push(i);
        }
        while (st.peek() != -1){
            area = array[st.pop()] * (i - st.peek() - 1);
            maxArea = Integer.max(area,maxArea);
        }
        return maxArea;
    }
    public static void main(String[] args) {
        int[] array = {2,1,5,6,2,3};
        System.out.println(largestRectangleInHistogramBrute(array));
        System.out.println(largestRectangleInHistogramBetter(array));
        System.out.println(largestRectangleInHistogramOptimal(array));
    }
}
