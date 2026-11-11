package prob;

public class SOME {
    static void main() {
        int n = 16;
        int cols = 5;
        int rows = n % cols == 0 ? n / cols : n / cols + 1;
        int val = 1;
        for (int row = 1; row <= rows; row++) {
            if (row % 2 == 1) {
                int[] rev = new int[cols];
                for (int col = 0; col < cols; col++) {
                    rev[col] = val++;
                }
                for (int col = cols - 1; col >= 0; col--) {
                    if (rev[col] <= n)
                        System.out.printf("%2d ", rev[col]);
                    else
                        System.out.print("   ");
                }
            } else {
                for (int col = 1; col <= cols; col++) {
                    if (val <= n)
                        System.out.printf("%2d ", val++);
                    else
                        System.out.print("   ");
                }
            }
            System.out.println();
        }
    }
}
