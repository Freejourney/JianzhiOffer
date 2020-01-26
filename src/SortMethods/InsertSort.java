package SortMethods;

public class InsertSort extends MSort {

    @Override
    public void test() {
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
        display(NUMS);
    }

    public static void main(String[] args) {
        new InsertSort().test();
    }
}

/*
    插入排序不断将后面的元素插入到前面有序序列中
 */