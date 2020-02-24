package SortMethods.Type2;

import SortMethods.MSort;

/**
 * Created by ua28 on 2/20/20.
 */
public class ShellSort extends MSort {

    @Override
    public void test() {
        shellSort();
        display(NUMS);
    }

    /**
     *  ShellSort just like a improved version of InsertSort.
     *  In this method, we cut half of the length every time to sort this array.
     */
    public void shellSort() {
        int d = NUMS.length;
        while (d > 1) {
            d = d/2;
            // use InsertSort() for every d-group
            for (int i = 0; i < d; i++) {
                for (int j = i+d; j < NUMS.length; j+=d) {
                    int tmp = NUMS[j];
                    int k = j-d;
                    for (; k>=0&&NUMS[k]>tmp; k-=d) {
                        NUMS[k+d] = NUMS[k];
                    }
                    NUMS[k+d] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        new ShellSort().test();
    }

}
