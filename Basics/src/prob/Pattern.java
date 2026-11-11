package prob;

public class Pattern {
    static void main() {
        int n=6;
        int size=2*n-1;
        int[][] arr=new int[size][size];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                int val=Math.min(Math.min(i,size-i-1),Math.min(j,size-j-1));
                arr[i][j]=n-val;

            }
        }
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

    }
}
