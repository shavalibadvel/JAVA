package prob;

public class Snake {
    static void main() {
        int total=71;
        int cols=10;
        int rows=(total+cols-1)/cols;
        int val=1;

        for(int r=0;r<rows;r++){

            if(r%2==0){
                for(int c=0;c<cols;c++){
                    if(val<=total){
                    System.out.printf("%2d ",val);
                    val++;}
                    else
                    System.out.print("   ");
                }
            }else{
                int[] row=new int[cols];
                for(int i=0;i<cols;i++){
                    row[i]=val+i;
                }
                for(int j=cols-1;j>=0;j--){
                    if(row[j]<=total){
                    System.out.printf("%2d ",row[j]);}
                    else
                    System.out.print("   ");
                }
                val+=cols;
            }
            System.out.println();
        }
    }
}
