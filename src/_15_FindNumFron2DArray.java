/**
 * Created by ua28 on 3/19/20.
 */
public class _15_FindNumFron2DArray {

    private int[][] arr = {
            {1, 2, 8, 9},
            {2, 4, 9, 12},
            {4, 7, 10, 13},
            {6, 8, 11, 15}
    };

    /**
     * from right-up corner to left or down
     *      for left: col--, arr[row][col] > num
     *      for down: row++, arr[row][col] < num
     *
     *      boundary is row and col (col>=0 row<=rows)
     *
     * @param num
     * @return
     */
    public boolean hasNum(int num) {
      int row = 0;
      int col = arr[0].length-1;

      while (row < arr.length && col >= 0) {
          if (arr[row][col] == num)
              return true;
          else if (arr[row][col] > num)
              col--;
          else
              row++;
      }

      return false;
    }

    public void test() {
        System.out.println(hasNum(7));
        System.out.println(hasNum(5));
    }

    public static void main(String[] args) {
        new _15_FindNumFron2DArray().test();
    }
}
