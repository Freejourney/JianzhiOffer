/**
 * Created by ua28 on 3/23/20.
 */
public class _16_PrintMatrixClockwisely {

    public void printMatrixClockwisely(int[][] matrix) {
        if (matrix == null)
            return;

        int start = 0;
        int cols = matrix[0].length;
        int rows = matrix.length;

        while (cols > start*2 && rows > start*2) {
            printMatrixInCircle(matrix, cols, rows, start);
            ++start;
        }
    }

    private void printMatrixInCircle(int[][] matrix, int cols, int rows, int start) {
        int endCol = cols - 1 - start;
        int endRow = rows - 1 - start;

        for (int i = start; i <= endCol; i++) {
            int number = matrix[start][i];
            System.out.print(number+" ");
        }

        if (start < endRow) {
            for (int i = start+1; i <= endRow; i++) {
                int number = matrix[i][endCol];
                System.out.print(number+" ");
            }
        }

        if (start < endCol && start < endRow) {
            for (int i = endCol-1; i >= start; i--) {
                int number = matrix[endRow][i];
                System.out.print(number + " ");
            }
        }

        if (start < endCol && start < endRow-1) {
            for (int i = endRow-1; i >= start+1; i--) {
                int number = matrix[i][start];
                System.out.print(number+" ");
            }
        }
    }


    public void test() {
        int[][] matrix = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        printMatrixClockwisely(matrix);
    }

    public static void main(String[] args) {
        new _16_PrintMatrixClockwisely().test();
    }
}
