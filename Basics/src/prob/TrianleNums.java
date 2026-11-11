package prob;

public class TrianleNums {
    static void main() {
        int n=5;
        int size=2*n-1;
        for(int i=0;i<n;i++){
            for(int j=size;j>=1;j--){
                if(j>=n+i || j<=n-i){
                    System.out.print(" * ");
                }else{
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
    }

    static void main(String[] args) {
        int n=5;
        int val=1;
//        for(int i=1;i<=n;i++){
//            for(int j=1;j<=n-i;j++){
//                System.out.print("   ");
//            }
//            for(int j=1;j<=2*i-1;j++){
//                System.out.printf(" %2d",val++);
//            }
//            System.out.println();
//        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i-1;j++){
                System.out.print("   ");
            }
            for(int j=1;j<=2*(n-i)+1;j++){
                System.out.printf(" %2d",val++);
            }
            System.out.println();
        }

    }
}
