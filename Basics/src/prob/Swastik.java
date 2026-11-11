package prob;

public class Swastik {
    static void main() {
        int rows=7;int cols=11;
        String[][] arr=new String[rows][cols];
        int val=1;
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                if(i<rows/2){
                    if(j<cols/2) {
                        if(j==0){
                            arr[i][j]=(val++)+"";
                        }else{
                            arr[i][j]="  ";
                        }
                    }else if(j==cols/2){
                        arr[i][j]=(val++)+"";
                    }else{
                        if(i==0){
                            arr[i][j]=(val++)+"";
                        }else{
                            arr[i][j]="  ";
                        }
                    }
                }else if(i<=rows/2){
                    arr[i][j]=(val++)+"";
                }else{
                    if(j==cols/2 || j==cols-1){
                        arr[i][j]=(val++)+"";
                    }else if (j<(cols/2)){
                        if(i==rows-1){
                            arr[i][j]=(val++)+"";
                        }else{
                            arr[i][j]="  ";
                        }
                    }else{
                        arr[i][j]="  ";
                    }
                }
            }
        }
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
