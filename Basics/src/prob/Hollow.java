package prob;

public class Hollow {
    static void main() {
        int n=5;
        int val=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i%n==0 || j%n==0 || i==n-1 || j==n-1){
                    System.out.printf(" %2d",val++);
                }else{
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
    }
}
