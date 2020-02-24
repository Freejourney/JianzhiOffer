package SortMethods.Type3;

import SortMethods.MSort;

public class BubbleSort extends MSort {

    @Override
    public void test() {
//        bubbleSort(true);
//        bubbleSort_prefixSorted(true);
        bubbleSort_suffixSorted();
        display(NUMS);
    }

    /**
     * original bubbleSort()
     * 最最基本的冒泡排序，不断比较相邻两个数的大小，如果相邻两个数不有序就将它们交换。
     * 每次内部循环一次找出当前未有序列最大的数。
     * 冒泡排序时间复杂度为O(n^2)
     * @param isAsc
     */
    public void bubbleSort(boolean isAsc) {
        for (int i = 0; i < NUMS.length; i++) {
            for (int j = 0; j < NUMS.length-i-1; j++) { // -1是因为j与j+1，不减的话第一次循环就越界了
                if (isAsc) {
                    if (NUMS[j] > NUMS[j + 1]) {
                        NUMS[j] = NUMS[j] ^ NUMS[j + 1];
                        NUMS[j + 1] = NUMS[j] ^ NUMS[j + 1];
                        NUMS[j] = NUMS[j] ^ NUMS[j + 1];
                    }
                } else {
                    if (NUMS[j] < NUMS[j + 1]) {
                        NUMS[j] = NUMS[j] ^ NUMS[j + 1];
                        NUMS[j + 1] = NUMS[j] ^ NUMS[j + 1];
                        NUMS[j] = NUMS[j] ^ NUMS[j + 1];
                    }
                }
            }
        }
    }

    /**
     * optimized bubbleSort - prefix nums are already sorted
     * 对前面的（左端）数字已经排序好了不用再进行循环了的优化
     * @param isAsc
     */
    public void bubbleSort_prefixSorted(boolean isAsc) {
        boolean switched;
        for (int i = 0; i < NUMS.length; i++) {
            switched = false;
            for (int j = 0; j < NUMS.length-i-1; j++) {
                if (isAsc) {
                    if (NUMS[j] > NUMS[j + 1]) {
                        NUMS[j] = NUMS[j] ^ NUMS[j + 1];
                        NUMS[j + 1] = NUMS[j] ^ NUMS[j + 1];
                        NUMS[j] = NUMS[j] ^ NUMS[j + 1];
                        switched = true;
                    }
                } else {
                    if (NUMS[j] < NUMS[j + 1]) {
                        NUMS[j] = NUMS[j] ^ NUMS[j + 1];
                        NUMS[j + 1] = NUMS[j] ^ NUMS[j + 1];
                        NUMS[j] = NUMS[j] ^ NUMS[j + 1];
                        switched = true;
                    }
                }
            }
            if (switched == false)
                break;
        }
    }

    /**
     *  Optimized BubbleSort() - Suffix nums are already sorted
     * 对后端的（右端）数字已经排好序了（数组原本这部分就有序）的情况将数组有序部分纳入排序有序部分，下次遍历不再遍历该有序部分
     */
    public void bubbleSort_suffixSorted() {
        int bound = NUMS.length-1;
        int lastExchangeIndex = bound;
        boolean isSorted;
        for (int i = 0; i < NUMS.length; i++) {
            isSorted = true;
            for (int j = 0; j < bound; j++) {
                if (NUMS[j] > NUMS[j+1]) {
                    int temp = NUMS[j];
                    NUMS[j] = NUMS[j+1];
                    NUMS[j+1] = temp;
                    isSorted = false;
                    lastExchangeIndex = j+1;
                }
            }
            bound = lastExchangeIndex;
            if (isSorted) {
                break;
            }
        }
    }

    /**
     * CockTailSort is also a kind of optimized bubbleSort method.
     * In CockTailSort, exchange process starts from left to right, then from right back to left, repeats this process.
     *
     * CockTailSort can effectively decrease the times of exchanging while the majority numbers are sorted.
     * 鸡尾酒排序，实际上就是冒泡排序来回交替遍历，从左往右，再从右往左。
     */
    public void cockTailSort() {
        int tmp = 0;
        int lastRightExchangeIndex = 0;
        int lastLeftExchangeIndex = 0;
        int rightSortBorder = NUMS.length - 1;
        int leftSortBorder = 0;

        for (int i = 0; i < NUMS.length/2; i++) {
            boolean isSorted = true;
            for (int j = leftSortBorder; j < rightSortBorder; j++) {
                if (NUMS[j] > NUMS[j+1]) {
                    tmp = NUMS[j];
                    NUMS[j] = NUMS[j+1];
                    NUMS[j+1] = tmp;

                    isSorted = false;
                    lastRightExchangeIndex = j;
                }
            }
            rightSortBorder = lastRightExchangeIndex;
            if (isSorted) {
                break;
            }

            isSorted = true;
            for (int j = rightSortBorder; j > leftSortBorder; j--) {
                if (NUMS[j] < NUMS[j-1]) {
                    tmp = NUMS[j];
                    NUMS[j] = NUMS[j-1];
                    NUMS[j-1] = tmp;

                    isSorted = false;
                    lastLeftExchangeIndex = j;
                }
            }
            leftSortBorder = lastLeftExchangeIndex;
            if (isSorted) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        new BubbleSort().test();
    }
}

/*
    冒泡排序每次内部循环找出最大(最小)的值放于一端
 */
