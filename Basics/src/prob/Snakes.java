package prob;

public class Snakes {
    static void main() {
        int n=16;
        int cols=5;
        int rows=n%cols==0?n/cols:n/cols+1;
        //System.out.println("rows: "+rows);
        int val=1;
        for(int row=1;row<=rows;row++) {
            int k=row%2;
            if(k==1) {
                for(int col=1;col<=cols;col++) {
                    System.out.print((val++)+" ");
                }

            }else{
                int[] rev=new int[cols];
                for(int col=cols;col>0;col--) {
                    rev[col-1]=val++;
                    //System.out.println(rev[col-1]);
                }

                for(int col=1;col<=cols;col++) {
                    if(rev[col-1]<=n) {
                        System.out.print(rev[col-1]+" ");
                    }
                    else{
                        System.out.print("   ");
                    }

                }

            }
            System.out.println();
        }
//        int n=16;
//        int rows=3;
//        int cols=n%rows==0?n/rows:n/rows+1;
//        int val=1;
//        int[][] arr=new int[rows][cols];
//        for(int col=1;col<=cols;col++) {
//            int k=col%2;
//            if(k==1){
//                for(int row=1;row<=rows;row++) {
//                    arr[row-1][col-1]=val++;
//                }
//            }
//            else{
//                for(int row=rows;row>=1;row--) {
//                    arr[row-1][col-1]=val++;
//                }
//            }
//
//        }
//        for(int row=0;row<rows;row++) {
//            for(int col=0;col<cols;col++) {
//                if(arr[row][col]<=n) {
//                    System.out.print(arr[row][col]+" ");
//                }else{
//                    System.out.print("  ");
//                }
//            }
//            System.out.println();
//        }
    }
}
