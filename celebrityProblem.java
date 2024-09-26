import java.util.Stack;

public class celebrityProblem {
     static int celebrity(int [][]array, int n){
        // code here
        int ans = -1,j;
        for(int i = 0;i < n; i++){
            for( j = 0;j < n; j++){
                if(array[i][j] == 1)break;
            }
            if(j == n) {
                ans = i;
                break;
            }
        }
        if(ans == -1)return ans;
        for(int i = 0 ; i < n ; i++){
            if(i == ans)continue;
            if(array[i][ans] == 0)return -1;
        }
        return ans;
    }
    static int celebrityProblemMethod(int [][] array,int n){
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            st.push(i);
        }
        while (st.size() > 1){
            int v1 = st.pop();
            int v2 = st.pop();
            if (array[v1][v2] == 1 && array[v2][v1] == 0)st.push(v2);
            else if (array[v1][v2] == 0 && array[v2][v1] == 1)st.push(v1);
        }
        if (st.isEmpty())return -1;
        else {
            int i = 0;
            while (i < n){
                 if  (st.peek() == i || (array[i][st.peek()] == 1 && array[st.peek()][i] == 0)){
                     i++;
                 }
                else return -1;
            }
            return st.peek();
        }
    }
    public static void main(String[] args) {
       int [][]M = {{0 ,1 ,0}, {1, 0, 0},{0, 1, 0}};
        System.out.println(celebrity(M,3));
    }
}
