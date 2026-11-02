
public abstract class ImplementClass1 implements interface1{
    public void main1() {

    }

    public int main4() {
        return 10;
    }
    public int main2() {
        return 0;
    }

    public int main3() {
        return 0;
    }
    static int main7(){
        return 0;
    }
    private int main8(){
        return 0;
    }
    ImplementClass1(){

    }
}
class ImplementClass2 extends ImplementClass1{

    public void method5() {
        System.out.println("method5");
    }


    public int main4() {
        return 0;
    }
    void main(){
        System.out.println("main");
        ImplementClass1 obj=new ImplementClass2();
        String s1="aaaa";
        String s2="aaaa";
        System.out.println(s1==s2);
        System.out.println(s1.equals(s2));
        System.out.println(obj.getClass());
    }
}
