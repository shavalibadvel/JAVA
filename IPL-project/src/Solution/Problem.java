package Solution;

import java.util.Arrays;

public class Problem {
    static void main() {
        int n=10;
        int k=2*n;
        int[][] res=new int[k-1][k-1];
        int c=n;
        for(int i=1;i<k;i++){
            //int[] arr=new int[2*n-1];
            //int index=0;
            for(int j=1;j<k;j++){

                int min=Math.min(Math.min(i%k,k-i%k),Math.min(j%k,k-j%k));
                int val=n-min+1;
                //arr[index++]=val;
                res[i-1][j-1]=val;
            }
//            for(int z=0;z<arr.length;z++){
//                System.out.print(arr[z]+" ");
//            }
//            System.out.println();
        }
        for(int i=0;i<res.length;i++){
            for(int j=0;j<res[0].length;j++){
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }

    }
}
