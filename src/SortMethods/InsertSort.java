package SortMethods;

public class InsertSort extends MSort {

    @Override
    public void test() {
        int[] nums = {1, 3, 2, 1, 4, 5, 0, 9, 8, 6, 7};

        for(int i = 1; i < nums.length; i++) {
            if (nums[i-1] > nums[i]) {

                int temp = nums[i];     // temp是比nums[i-1]小的nums[i]
                for (int j = i; j >= 0; j--) {
                    if (j > 0 && nums[j-1] > temp) {
                        nums[j] = nums[j-1];
                    } else {
                        nums[j] = temp; // 在所有元素都向右移一位后 或 num[j]<=temp时插入，插的位置是上一个元素右移后留下的位置，也就是新的相同的元素会放在左边
                        break;
                    }
                }

            }
        }
        display(nums);
    }

    public static void main(String[] args) {
        new InsertSort().test();
    }
}
