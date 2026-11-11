package prob;

public class StairCase {
    static void main() {
        int n=19;
        int val=1;
        for(int i=1;i<=n;i++){
            int k=i%2==0?i:i+1;
            for(int j=1;j<=k;j++){
                System.out.printf(" %2d",val++);
            }
            System.out.println();

        }
    }
}
