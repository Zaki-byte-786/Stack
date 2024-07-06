public class trappingRainwaterOptimizeConstantSpace {
    static int trappingWater(int[] array){
        int n = array.length;
        int i = 1,j = n-2,leftMax = array[0],rightMax = array[n-1],ans = 0;
        while (i <= j){
            if (leftMax < rightMax){
                if (leftMax < array[i])leftMax = array[i];
                else ans += leftMax - array[i++];
            }
            else {
                if (rightMax < array[j])rightMax = array[j];
                else ans += rightMax - array[j--];
            }
        }
        return ans;
    }
    public static void main(String[] args) {
int [] array = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trappingWater(array));
    }
}
