public class trappingRainwater {
    static int trappingRainwaterMethod(int[] array){

        int waterStored = 0;
        int n = array.length;
        for (int i = 1; i < n-1; i++) {
            int leftMax = 0;
            int rightMax = 0;
            for (int j = i; j >= 0 ; j--) {
                if (array[j] > leftMax){
                    leftMax = array[j];
                }
            }
            for (int j = i; j < n; j++) {
                if (array[j] > rightMax){
                    rightMax = array[j];
                }
            }
            waterStored += Integer.min(leftMax,rightMax) - array[i];
        }
        return waterStored;
    }
    public static void main(String[] args) {
int [] array = {4,2,0,3,2,5};
        System.out.println(trappingRainwaterMethod(array));
    }
}
