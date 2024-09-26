import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class slidingWindowMaximum {
    static int[] slidingWindowMaximumBrute(int[] array,int k){

        int n = array.length,r = 0;
        int[] ans = new int[n-k+1];
        for (int i = 0; i <= n - k; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j <= i + k - 1; j++) {
                max = Integer.max(max,array[j]);
            }
            ans[r++] = max;
        }
        return ans;
    }
    static int[] slidingWindowMaximumOptimal(int[] array,int k){
        int n = array.length,j = 0;
        int[] ans = new int[n-k+1];
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!dq.isEmpty() && dq.getLast() < array[i]) dq.removeLast();
            dq.addLast(array[i]);
        }
            ans[j++] = dq.getFirst();
        for (int i = k; i < n; i++) {
            if (array[i-k] == dq.getFirst())dq.removeFirst();
            while (!dq.isEmpty() && dq.getLast() < array[i]) dq.removeLast();
            dq.addLast(array[i]);
            ans[j++] = dq.getFirst();
        }
        return ans;
    }
    public static void main(String[] args) {
int [] array = {-7,-8,7,5,7,1,6,0};
        System.out.println(Arrays.toString(slidingWindowMaximumBrute(array,3)));
        System.out.println(Arrays.toString(slidingWindowMaximumOptimal(array,3)));
        Deque<Integer> dq = new LinkedList<>();
        dq.addFirst(1);
        dq.getFirst();
        System.out.println(dq.size());
    }
}
