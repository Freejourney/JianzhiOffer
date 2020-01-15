package SortMethods;

public class BubbleSort extends MSort {


    @Override
    public void test() {
        int[] nums = {1, 3, 2, 1, 4, 5, 0, 9, 8, 6, 7};

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length-i-1; j++) { // -1是因为j与j+1，不减的话第一次循环就越界了
                if (nums[j] > nums[j+1]) {
                    nums[j] = nums[j] ^ nums[j+1];
                    nums[j+1] = nums[j+1] ^ nums[j];
                    nums[j] = nums[j] ^ nums[j+1];
                }
            }
        }

        display(nums);
    }

    public static void main(String[] args) {
        new BubbleSort().test();
    }
}
