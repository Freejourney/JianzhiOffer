package SortMethods.Type3;

import SortMethods.MSort;

public class InsertSort extends MSort {

    @Override
    public void test() {
        insertSort();
        display(NUMS);
    }

    /**
     * 假设序列最前端是有序的，暂存当前数，将有序的数列逐个向后移动覆盖掉当前数，
     * 待找到当前数应该在的位置时将暂存的当前数覆盖过去
     */
    public void insertSort_o() {
        for(int i = 1; i < NUMS.length; i++) {
            if (NUMS[i-1] > NUMS[i]) {

                int temp = NUMS[i];     // temp是比NUMS[i-1]小的NUMS[i]
                for (int j = i; j >= 0; j--) {
                    if (j > 0 && NUMS[j-1] > temp) {
                        NUMS[j] = NUMS[j-1];
                    } else {
                        NUMS[j] = temp; // 在所有元素都向右移一位后 或 num[j]<=temp时插入，插的位置是上一个元素右移后留下的位置，也就是新的相同的元素会放在左边
                        break;
                    }
                }

            }
        }
    }

    /**
     * 相同的意思不同的写法
     */
    public void insertSort() {
        for (int i = 1; i < NUMS.length; i++) {
            // save current value aside
            int insertValue = NUMS[i];

            // move sorted array toward right until NUM[j] is not larger than insertValue
            int j = i-1;
            for (; j >= 0 && NUMS[j] > insertValue; j--) {
                NUMS[j+1] = NUMS[j];
            }

            NUMS[j+1] = insertValue;
        }
    }

    public static void main(String[] args) {
        new InsertSort().test();
    }
}

/*
    插入排序不断将后面的元素插入到前面有序序列中
 */