package SortMethods;

public class QuickSort extends MSort {
    @Override
    public void test() {
        Quick_Sort(NUMS, 0, NUMS.length-1);
        display(NUMS);
    }

    private void Quick_Sort(int[] nums, int l, int r) {
        if (l < r) {
            int flag = NUMS[l];

            int i = l, j = r;
            while (i < j) {
                while (i < j && flag <= NUMS[j]) {
                    j--;
                }
                if (i < j) {
                    nums[i++] = nums[j];
                }

                while (i < j && flag > NUMS[i]) {
                    i++;
                }
                if (i < j) {
                    nums[j--] = nums[i];
                }
            }
            nums[i] = flag;

            Quick_Sort(nums, l, i - 1);
            Quick_Sort(nums, i + 1, r);
        }
    }

    public static void main(String[] args) {
        new QuickSort().test();
    }
}

/*
    快速排序递归排序指定一个位置并选取该位置元素为标准遍历区间将大于小于该数的元素分别置于两端
 */