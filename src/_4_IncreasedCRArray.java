public class _4_IncreasedCRArray {

    private int[][] mArray = {
            {1, 2, 8, 9},
            {2, 4, 9, 12},
            {4, 7, 10, 13},
            {6, 8, 11, 15}
    };

    public boolean isExist(int num) {
        int c = mArray[0].length;
        int r = mArray.length;

        int ic = c-1, ir = 0;
        while (true) {
            if (mArray[ir][ic] == num) {
                return true;
            }
            if (mArray[ir][ic] < num) {
                ir++;
                if (ir >= r) {
                    return false;
                }
            }
            if (mArray[ir][ic] > num) {
                ic--;
                if (ic < 0) {
                    return false;
                }
            }
        }
    }

    public boolean isExist_2(int rows, int columns, int num) {
        boolean found = false;

        if (rows > 0 && columns > 0) {
            int row = 0;
            int column = columns - 1;

            while (row < rows && column >= 0) {
                if (mArray[row][column] == num) {
                    found = true;
                    break;
                } else if (mArray[row][column] > num) {
                    column--;
                } else {
                    row++;
                }
            }
        }

        return found;
    }

    public static void main(String[] args) {
        System.out.println(new _4_IncreasedCRArray().isExist(0));
        System.out.println(new _4_IncreasedCRArray().isExist_2(4, 4, 0));
    }
}
