package prob;

public class TraingleNums {
    static void main() {
        int n=5;
        for(int i=1;i<=n;i++){
            for(int j=1;j<i;j++){
                System.out.print("   ");
            }
            for(int j=1;j<=2*(n-i+1)-1;j++){

                System.out.printf(" %2d",(n-i+1) );
            }
            System.out.println();
        }
        for(int i=2;i<=n;i++){
            for(int j=1;j<=n-i;j++){
                System.out.print("   ");
            }
            for(int j=1;j<=2*(i-1)+1;j++){
                System.out.printf(" %2d",i );
            }
            System.out.println();
        }
//        for(int i=2;i<=n;i++){
//            for(int j=n-i+1;j>=1;j--){
//                System.out.print("   ");
//            }
//            for(int j=1;j<=i;j++){
//                System.out.printf(" %2d",i );
//            }
//            System.out.println();
//        }
    }
}
