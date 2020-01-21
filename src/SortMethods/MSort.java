package SortMethods;

public abstract class MSort {

    protected int[] NUMS = {1, 3, 2, 1, 4, 5, 0, 9, 8, 6, 7};
    protected int[] NUMS2 ={1, 3, 2, 4, 5, 0, 9, 8, 6, 7};

    public abstract void test();

    public void display(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
        System.out.println();
    }
}
