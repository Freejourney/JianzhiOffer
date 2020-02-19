package SortMethods;

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