import java.util.Random;

public class _3_RepeatedNum_NoModify extends Tools {

    public int findRepeatedNumInArray(int[] nums) {
        return TwoDivFindWay(nums);
    }

    private int TwoDivFindWay(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;

        int start = 1;
        int end = nums.length-1;

        while (end>=start) {
            int middle = ((end-start)>>1) + start;

            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= middle && nums[i] >= start) {
                    count++;
                }
            }

            // end和start相等只是在数组中仅搜索同一个数(值等于endstartmiddle)，而不是下标
            if (end == start) {
                if (count > 1)
                    return start;
                else
                    break;
            }

            if (count > (middle-start+1))
                end = middle;
            else
                start = middle + 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int n = 20;
        int[] nums = new int[n+1];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(n)+1;
        }
        System.out.println(new _3_RepeatedNum_NoModify().findRepeatedNumInArray(nums));
    }
}
