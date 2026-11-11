package prob;

import static java.lang.Math.abs;

public class DiamondNumbers {
    static void main() {
        int n=5;
        int st=1;
        int[][] arr=new int[n][];
        for(int i=0;i<n;i++){
            arr[i]=new int[st];
            int count=st/2+1;
            for(int j=0;j<st;j++){
                arr[i][j]=count;
                if(j<st/2){
                    count--;
                }
                else{
                    count++;
                }
            }
            if(i<n/2){
                st+=2;
            }else{
                st-=2;
            }
        }
        int sp=n/2;
        for(int i=0;i<n;i++){
            for(int j=1;j<=sp;j++){
                System.out.print("  ");
            }
            for(int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
            if (i<n/2){
                sp-=1;
            }
            else{
                sp+=1;
            }
        }
//        int n=5;
//        int sp=n/2,st=1;
//        for(int i=1;i<=n;i++) {
//            for(int j=1;j<=sp;j++)
//            System.out.print("  ");
//            int count=st/2+1;
//            for(int j=1;j<=st;j++) {
//                System.out.print(count+" ");
//                if(j<=st/2)
//                count--;
//                else
//                count++;
//            }
//            System.out.println();
//            if(i<=n/2){
//                sp=sp-1;
//                st+=2;
//
//            }else{
//                sp+=1;
//                st-=2;
//            }
//        }
//        int n=5;
//        int val=1;
//        int[][] arr=new int[2*n-1][2*n-1];
//        for(int j=1;j<2*n;j++){
//            for(int i=1;i<2*n;i++){
//                if((abs(i-n)+abs(j-n))<n){
//                    arr[j-1][i-1]=val++;
//                }else{
//                    arr[j-1][i-1]=0;
//                }
////                if( j<n && i<n+j && i>n-j){
////                    arr[i-1][j-1]=val++;
////                }else if(j>=n && i>j-n && i<3*n-j){
////                       arr[i-1][j-1]=val++;
////                }
////                else {
////                    arr[i-1][j-1]=0;
////                }
//            }
//        }
//        for(int i=0;i<2*n-1;i++){
//            for(int j=0;j<2*n-1;j++){
//                if(arr[i][j]!=0){
//                    System.out.printf(" %2d",arr[i][j]);
//                }else{
//                    System.out.print("   ");
//                }
//
//            }
//            System.out.println();
//        }
    }
}
