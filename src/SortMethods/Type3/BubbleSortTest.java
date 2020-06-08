package SortMethods.Type3;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ua28 on 6/8/20.
 */
public class BubbleSortTest {

    private void bubbleSortClassic(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length-i-1; j++) {
                if (nums[j] > nums[j+1]) {
                    nums[j] = nums[j] ^ nums[j+1];
                    nums[j+1] = nums[j] ^ nums[j+1];
                    nums[j] = nums[j] ^ nums[j+1];
                }
            }
        }
    }

    /**
     * no exchange means every two closed elements are sorted
     *
     * 前缀是最后比较的，每次选取最大值放在最后面，这样一次比较直至前缀有序就可结束
     * @param nums
     */
    private void prefiexedBubbleSortClassic(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean flag = false;
            for (int j = 0; j < nums.length-i-1; j++) {
                if (nums[j] > nums[j+1]) {
                    nums[j] = nums[j] ^ nums[j+1];
                    nums[j+1] = nums[j] ^ nums[j+1];
                    nums[j] = nums[j] ^ nums[j+1];
                    flag = true;
                }
            }
            if (!flag)
                break;
        }
    }

    private void suffixed_PrefixedBubbleSortClassic(int[] nums) {
        int bound = nums.length-1;
        int lastExchange = bound;
        for (int i = 0; i < nums.length; i++) {
            boolean flag = false;
            for (int j = 0; j < bound; j++) {
                if (nums[j] > nums[j+1]) {
                    nums[j] = nums[j] ^ nums[j+1];
                    nums[j+1] = nums[j] ^ nums[j+1];
                    nums[j] = nums[j] ^ nums[j+1];
                    flag = true;
                    lastExchange = j+1;
                }
            }
            bound = lastExchange;
            if (!flag)
                break;
        }
    }

    /**
     * Arrays.toString() to output content of array
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {1,5,2,3,4};

//        new BubbleSortTest().bubbleSortClassic(nums);
//        new BubbleSortTest().prefiexedBubbleSortClassic(nums);
        new BubbleSortTest().suffixed_PrefixedBubbleSortClassic(nums);

        System.out.println(Arrays.toString(nums));
    }
}
