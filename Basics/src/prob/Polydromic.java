package prob;

public class Polydromic {
    static void main() {
        int n=5;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i;j++){
                System.out.print("  ");
            }
            for(int j=1;j<=i;j++){
                System.out.print(j+" ");
            }
            for(int j=i-1;j>=1;j--){
                System.out.print(j+" ");
            };
            System.out.println();

        }
//        int n=5;
//        for(int i=1;i<=n;i++) {
//            for(int j=1;j<=n-i;j++) System.out.print("  ");
//            for(int j=1;j<=i;j++) System.out.print(j+" ");
//            for(int j=i-1;j>=1;j--) System.out.print(j+" ");
//            System.out.println();
//        }

    }
}
