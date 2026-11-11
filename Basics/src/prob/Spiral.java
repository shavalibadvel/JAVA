package prob;

public class Spiral {
    static void main() {
        int n=5;
        int[][] arr=new int[n][n];
        int val=1;
        int top=0,bottom=n-1,left=0,right=n-1;
        while(top<=bottom && left<=right){
            for(int i=left;i<=right;i++){
                arr[top][i]=val++;
            }
            top++;
            for(int i=top;i<=bottom;i++){
                arr[i][right]=val++;
            }
            right--;
            if(top<=bottom){
                for(int i=right;i>=left;i--){
                    arr[bottom][i]=val++;
                }

            }
            bottom--;
            if(left<=right){
                for(int i=bottom;i>=top;i--){
                    arr[i][left]=val++;
                }

            }
            left++;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.printf(" %2d",arr[i][j]);
            }
            System.out.println();
        }
    }
}
