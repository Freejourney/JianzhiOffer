/**
 * Created by ua28 on 3/17/20.
 */
public class _13_MoveOddEvenNumbers {

    public void moveOddEvenNumbers(int[] arr) {
        int left = 0, right = arr.length-1;

        while (left <= right) {
            while (arr[left] % 2 == 1)
                left++;
            while (arr[right] % 2 == 0)
                right--;

            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
        }
    }

    public void test() {
        int[] arr = new int[]{4, 1, 2, 3, 5, 9, 0, 12, 11, 13};
        moveOddEvenNumbers(arr);

        for (int i : arr) {
            System.out.print(i+" ");
        }
    }

    public static void main(String[] args) {
        new _13_MoveOddEvenNumbers().test();
    }
}
