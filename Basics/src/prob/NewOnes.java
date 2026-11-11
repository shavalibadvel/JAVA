package prob;

public class NewOnes {

    static void main() {
       //pattern1(4);
        pattern2(5);
    }
    static void pattern2(int n){
        for(int i=1;i<=n;i++){
            for(char j='A';j<'A'+i;j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
    static void pattern3(){
    }
    static void pattern4(){}
    static void pattern1(int n){
        int sp=2*n;
        for(int i=1;i<=n;i++){
            sp=2*n-2*i;
            for(int j=1;j<=i;j++ ){
                System.out.print(j+" ");
            }
            for(int j=1;j<=sp;j++){
                System.out.print("  ");
            }
            for(int j=i;j>=1;j--){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}
