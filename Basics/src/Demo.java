import java.io.*;

public class Demo {
    static void method1() throws IOException{
        int[] arr=new int[10];
        String str;

        try{

            FileReader fr = new FileReader("data.txt");
            System.out.println(arr[11]);
            System.out.println("");

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) throws IOException {

        method1();
        System.out.println("main");
        try{
            String[] a=new String[10];
            a[0]="hello";


        }catch(Exception e){
            System.out.println(e);
        }

    }
}
