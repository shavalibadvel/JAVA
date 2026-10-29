public class SwitchClass {
    public static void main(String[] args) {
        var key= 'x';
        String quarterLabel=null;
        switch (key) {
            case 'a':
                quarterLabel = "Q1 - Winter";
                break;
            case 'b':
                quarterLabel = "Q2 - Spring";
                break;
            case 'c':
                quarterLabel = "Q3 - Summer";
                break;
            case 'd':
                quarterLabel = "Q4 - Rainy";
                break;
            case 1:
                quarterLabel = "it doesn't work with int values";
                break;
            case 2:
                quarterLabel = "it doesn't work with long values";
                 break;
            default:
                quarterLabel = "Unknown quarter";
                break;
            case 'e':
                quarterLabel = "Q5 - Some Good ";
                break;

        }
        System.out.println(quarterLabel);
    }
}
