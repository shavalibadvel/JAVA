package prob;

public class Practice {
    static void main() {
        //pyramid
//        int n=4;
//        //int val=1;
//        for(int i=1;i<=n;i++) {
//            for(int j=1;j<=n-i;j++) {
//                System.out.print(" ");
//            }
//            for(int j=1;j<=i;j++) {
//                System.out.print(i+" ");
//            }
//            System.out.println();
//        }
//        int val=1;
//        int n=4;
//        for(int i=1;i<=n;i++){
//            for(int j=1;j<=i;j++){
//                System.out.print(val+++" ");
//            }
//            System.out.println();
//        }
        //pascals triangle
//        int n=5;
//        int[][] arr=new int[n][];
//        for(int i=0;i<n;i++){
//            arr[i]=new int[i+1];
//            arr[i][0]=1;arr[i][i]=1;
//            for(int j=1;j<i;j++){
//                arr[i][j]=arr[i-1][j-1]+arr[i-1][j];
//            }
//
//        }
//        for(int i=0;i<n;i++){
//            for(int j=0;j<n-i-1;j++){
//                System.out.print(" ");
//            }
//            for(int j=0;j<=i;j++){
//                System.out.print(arr[i][j]+" ");
//            }
//            System.out.println();
//        }
        //diamond
        int n=4;
        int val=1;
        for(int i=1;i<2*n;i++){
            if(i<=n) {
                for (int j = 1; j <= n - i; j++) {
                    System.out.print(" ");
                }
                for (int j = 1; j <= i; j++) {
                    System.out.print(i+" ");
                }

            }
            else{
                val-=1;
                for (int j = 1; j <=i-n; j++) {
                    System.out.print(" ");
                }
                for (int j = 1; j <= 2*n-i; j++) {
                    System.out.print(2*n-i+" ");
                }

            }
            System.out.println();
        }
    }
}
