import java.util.Arrays;
import java.util.HashMap;

public class _3_RepeatedNum extends Tools {

    public int findRepeatedNumInArray(int[] nums) {
        int flag = 0;

        System.out.println(SortArrayWay(nums, flag));
//        System.out.println(HashMapWay(nums, flag));
//        System.out.println(SwapWay(nums));

        return 0;
    }

    /*
        从第一个元素开始不断交换，将元素放到排序正确后的位置，重复出现时立刻能够发现
     */
    private int SwapWay(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }

        for (int i = 0; i < nums.length; i++)
            if (nums[i] < 0 || nums[i] > nums.length-1)
                return -1;

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }

                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }

        return -1;
    }

    private int HashMapWay(int[] nums, int flag) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.get(nums[i])!=null) {
                return nums[i];
            } else {
                hashMap.put(nums[i], 1);
            }
        }
        flag = -1;
        return -1;
    }

    private int SortArrayWay(int[] nums, int flag) {
        Arrays.sort(nums);
//        ShowArray(nums);
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == nums[i+1]) {
                return nums[i];
            }
        }
        flag = -1;
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 3, 3, 5, 6, 6, 4};
        new _3_RepeatedNum().findRepeatedNumInArray(nums);
    }

}
