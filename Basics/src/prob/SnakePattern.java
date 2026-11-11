package prob;

public class SnakePattern {
    public static void main(String[] args) {
        int total = 16;   // print numbers 1 to 16
        int cols = 5;     // 5 numbers per row

        int rows = (total + cols - 1) / cols;
        int value = 1;

        for (int r = 0; r < rows; r++) {
            if (r % 2 == 0) {
                // even row: left to right
                for (int c = 0; c < cols; c++) {
                    if (value <= total) {
                        System.out.printf("%2d ", value);
                        value++;
                    } else {
                        System.out.print("   ");
                    }
                }
            } else {
                // odd row: right to left
                int[] row = new int[cols];

                for (int c = 0; c < cols; c++) {
                    row[c] = value + c;
                }

                for (int c = cols - 1; c >= 0; c--) {
                    if (row[c] <= total) {
                        System.out.printf("%2d ", row[c]);
                    } else {
                        System.out.print("   ");
                    }
                }

                value += cols;
            }

            System.out.println();
        }
    }
}
