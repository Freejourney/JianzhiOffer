package SortMethods.Type3;

import SortMethods.MSort;

/**
 * Created by ua28 on 2/20/20.
 */
public class SelectSort extends MSort {

    /**
     * 每次内层遍历找到序列中最小的数与其应该在的位置进行交换
     */
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
