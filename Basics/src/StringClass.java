public  class StringClass {
    public static void main(String[] args) {
        ChildClass childClass = new ChildClass();
        SuperClass p=new ChildClass();
        System.out.println("Hello"=="Hello");//false
        System.out.println("Hello".equals("Hello"));//false
        p.main1();
    }

}
