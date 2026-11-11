package prob;

public class Pyramid {
    static void main() {
        int val=0;
        int n=5;
        for(int i=1;i<=5;i++) {
            for(int j=1;j<=2*n-1;j++) {
                if(j>n-i && j<n+i){
                    if(j>=n+1){
                        val=val-1;
                        System.out.printf(" %2d",val);
                    }else{
                        val=val+1;
                        System.out.printf(" %2d",val);
                    }
                }else{
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
    }
}
