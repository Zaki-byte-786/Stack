import java.util.Arrays;

public class trappingRainwaterOptimize {
    public static void main(String[] args) {
    int [] array = {0,1,0,2,1,0,1,3,2,1,2,1};
    int n = array.length;
    int [] psa = new int[n];
        int [] ssa = new int[n];
    int max = 0;
        for (int i = 0; i < n; i++) {
            if (max < array[i]){
                max = array[i];
            }
                psa[i] = max;
        }
        max = 0;
        for (int i = n-1; i >= 0 ; i--) {
            if (max < array[i]){
                max = array[i];
            }
            ssa[i] = max;
        }
        int waterStored = 0;
        for (int i = 1; i < n-1; i++) {
            waterStored += Integer.min(psa[i],ssa[i]) - array[i];
        }
        System.out.println(Arrays.toString(psa));
        System.out.println(Arrays.toString(ssa));
        System.out.println(waterStored);
    }
}
