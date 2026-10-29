public class StringClass {
    public static void main(String[] args) {
        String name="shavali";
        //convert string to number
        String age="25";
        float f1=(Float.valueOf(age)).floatValue();
        System.out.println(name+" "+age+" "+f1);
        Integer i1=(Integer.valueOf(age)).intValue();
        System.out.println(i1+" "+age+" "+f1);
        double d1=Double.parseDouble(age);
        System.out.println(d1+" "+age+" "+f1);
        // Integer → binary string (there is no binary() method)
        String bitcode = Integer.toBinaryString(i1); // 25 → "11001"
        System.out.println(bitcode);

        // Same idea with other bases:
        // Integer.toHexString(i1);  // hex
        // Integer.toOctalString(i1); // octal
        // Integer.toString(i1, 2);   // also binary
    }
}
