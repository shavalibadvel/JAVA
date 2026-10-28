//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
//void main() {
//    int v1;
//    byte v2;
//    short v3;
//    long v4;
//    double v5;
//    float v6;
//    char v7;
//    boolean v8;
//}
class Main {
    public static void main(String[] args) {
        int v1 = 0;
        byte v2=0;
        short v3=2*2;
        long v4=10;
        double v5=10;
        float v6=10;
        char v7='c';
        boolean v8=true;
        System.out.println(" default value of byte:"+v2);
        System.out.println(" default value of short: "+v3);
        System.out.println(" default value of int:"+v1);
        System.out.println(" default value of long:"+v4);
        System.out.println(" default value of float:"+v5);
        System.out.println(" default value of double:"+v6);
        System.out.println(" default value of char:"+v7);
        System.out.println(" default value of boolean:"+v8);
        m1();
    }
    static void m1(){
        System.out.println("m1");
    }
}
