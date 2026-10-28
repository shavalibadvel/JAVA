import java.util.Arrays;

public class ArraysFile {
    public static void main(String[] args) {
        // Arrays initialization
        //1
        //declaration
        int[] intArrray;
        int intArray1[];
        //initialization
        intArrray=new int[10];
        intArrray[0]=1;
        intArrray[1]=2;

        int intArray2[]=new int[10];
        // size must be added for new int[size]

        //initialization
        intArray1=new int[]{1,2,3,4};
        intArray2=new int[5];
        //multi dimenstions declaration
        int[][] a;
        int b[][];
        int[] c[];
        //intitalization
        a=new int[5][];
        //second size we can define explicitely for each element array
        a[0]=new int[3];


        System.arraycopy(intArray1,0,intArray2,0,3);;
        System.out.println(" Array 2: "+ Arrays.toString(intArray2));
    }
}
