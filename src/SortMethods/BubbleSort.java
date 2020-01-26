package SortMethods;

public class BubbleSort extends MSort {

    @Override
    public void test() {
        for (int i = 0; i < NUMS.length; i++) {
            for (int j = 0; j < NUMS.length-i-1; j++) { // -1是因为j与j+1，不减的话第一次循环就越界了
                if (NUMS[j] > NUMS[j+1]) {
                    NUMS[j] = NUMS[j] ^ NUMS[j+1];
                    NUMS[j+1] = NUMS[j+1] ^ NUMS[j];
                    NUMS[j] = NUMS[j] ^ NUMS[j+1];
                }
            }
        }

        display(NUMS);
    }

    public static void main(String[] args) {
        new BubbleSort().test();
    }
}

/*
    冒泡排序每次内部循环找出最大(最小)的值放于一端
 */