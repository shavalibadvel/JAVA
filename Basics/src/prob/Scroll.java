package prob;

public class Scroll {
    static void main() {
        int n=7;
        int m=7;
        int val=1;
        int[][] arr=new int[n][m];
        int top=0,bottom=n-1;
        int left=0,right=m-1;
        while(top<=bottom && left<=right){
            for (int i=left; i<=right; i++) {
                arr[top][i]=val++;
            }
            top++;
            for (int i=top; i<=bottom; i++) {
                arr[i][right]=val++;
            }
            right--;
            if(top<=bottom){
                for (int i=right; i>=left; i--) {
                    arr[bottom][i]=val++;
                }
                bottom--;
            }
            if(left<=right){
                for (int i=bottom; i>=top; i--) {
                    arr[i][left]=val++;
                }
                left++;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
