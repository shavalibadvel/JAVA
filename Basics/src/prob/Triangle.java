package prob;

public class Triangle {
    static void main() {
        int n=5;
        int[][] arr=new int[n][n];
        int rows=arr.length;
        int cols=arr[0].length;
        for(int i=0;i<rows;i++){
            for(int j=cols-1;j>=0;j--){
                if(j<=i){
                    System.out.print(" * ");
                }else{
                    System.out.print("   ");

                }

            }
            System.out.println();
        }
    }
}
