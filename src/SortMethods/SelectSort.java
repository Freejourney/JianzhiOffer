package SortMethods;

/**
 * Created by ua28 on 2/20/20.
 */
public class SelectSort extends MSort {

    public void selectSort() {
        for (int i = 0; i < NUMS.length-1; i++) {
            int minIndex = i;
            // find the minimum num index
            for (int j = i+1; j < NUMS.length; j++) {
                minIndex = NUMS[minIndex] > NUMS[j] ? j : minIndex;
            }
            int tmp = NUMS[minIndex];
            NUMS[minIndex] = NUMS[i];
            NUMS[i] = tmp;
        }
    }

    @Override
    public void test() {
        selectSort();
        display(NUMS);
    }

    public static void main(String[] args) {
        new SelectSort().test();
    }
}
