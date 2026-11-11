package prob;

public class Pascals {
    static void main() {
        int n=10;
        int[][] arr=new int[n][];
        for(int i=0;i<n;i++){
            arr[i]=new int[i+1];
            arr[i][0]=arr[i][i]=1;
            for(int j=1;j<i;j++){
                arr[i][j]=arr[i-1][j]+arr[i-1][j-1];
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n-i-1;j++){
                System.out.print(" ");
            }
            for(int j=0;j<i+1;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();

        }
    }
}
