public class SwitchCase {
    public static void main(String[] args)
    {
        char grade;
        int marks = 90;

        // Option 1: classic switch — switch on a range "bucket" (marks / 10)
        // 90-100 → 9 or 10, 80-89 → 8, etc.
        switch (marks / 10) {
            case 10: // 100
            case 9:  // 90-99
                grade = 'A';
                break;
            case 8:  // 80-89
                grade = 'B';
                break;
            case 7:  // 70-79
                grade = 'C';
                break;
            case 6:  // 60-69
                grade = 'D';
                break;
            case 5:  // 50-59
                grade = 'E';
                break;
            default:
                grade = 'F';
        }

        System.out.println("Marks: " + marks + ", Grade: " + grade);
        int month_num=10;
        String month=switch (month_num){
            case 1-> "January";
            case 2-> "February";
            case 3-> "March";
            case 4-> "April";
            case 5-> "May";
            case 6-> "June";


            case 7-> "July";
            case 8-> "August";
            case 9-> "September";
            case 10-> "October";
            case 11-> "November";
            case 12-> "December";
            default -> "Invalid Input";
        };
        System.out.println("Month: " + month);

        // Option 2 (Java 21+): real conditions with "when" guards
        // Uncomment if your JDK is 21 or newer:

//        grade = switch (marks) {
//            case  int m when m >= 90 && m <= 100 -> 'A';
//            case int m when m >= 80 -> 'B';
//            case m >= 70 -> 'C';
//            case m >= 60 -> 'D';
//            case  m >= 50 -> 'E';
//            default -> 'F';
//        };

    }
}
