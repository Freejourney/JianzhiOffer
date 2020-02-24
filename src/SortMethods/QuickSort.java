package SortMethods;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class QuickSort extends MSort {
    @Override
    public void test() {
//        QuickSort(NUMS, 0, NUMS.length-1);
//        display(NUMS);

//        display("unsorted NUMS: ", NUMS);
//        QuickSortFP(NUMS);
//        display("UNMS shouldn't be changed: ", NUMS);

//        display(NUMS);
//        quickSortSwithPointers(NUMS, 0, NUMS.length-1);
//        display(NUMS);

        display(NUMS);
        quickSortSwithPointersWithStack(NUMS, 0, NUMS.length-1);
        display(NUMS);
    }

    public void quickSort(int[] nums, int l, int r) {
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

            quickSort(nums, l, i - 1);
            quickSort(nums, i + 1, r);
        }
    }

    /**
     * Main Function
     *
     * implemented non-original array sort
     * @param onums
     */
    public void quickSortFP(int[] onums) {
        // copy array to a new array
        int[] nums = new int[onums.length];
        for (int i = 0; i < onums.length; i++) {
            nums[i] = onums[i];
        }
        quickSortFillPit(nums, 0, nums.length-1);
        display("in nums: ", nums);
    }

    // invoked recursion function
    public void quickSortFillPit(int[] nums, int l, int r) {
        if (l < r) {
            int privot = nums[l];
            int i = l, j = r;
            while (i < j) {
                while (nums[j] >= privot && j > i) {
                    j--;
                }
                if (i < j) {
                    nums[i++] = nums[j];
                }
                while (nums[i] < privot && i < j) {
                    i++;
                }
                if (i < j) {
                    nums[j--] = nums[i];
                }
            }
            nums[i] = privot;

            quickSortFillPit(nums, l, i-1);
            quickSortFillPit(nums, i+1, r);
        }
    }

    /**
     * divide a array into two half-sorted parts, repeat this processes
     * @param nums
     * @param startIndex
     * @param endIndex
     */
    public void quickSortSwithPointers(int[] nums, int startIndex, int endIndex) {
        if (startIndex >= endIndex)
            return;

        int dividIndex = quickSortSwithPointersPartition(nums, startIndex, endIndex);
        quickSortSwithPointers(nums, startIndex, dividIndex-1);
        quickSortSwithPointers(nums, dividIndex+1, endIndex);
    }

    /**
     * QuickSort without recursion
     * @param nums
     * @param startIndex
     * @param endIndex
     */
    public void quickSortSwithPointersWithStack(int[] nums, int startIndex, int endIndex) {
        if (startIndex >= endIndex)
            return;

        // use collection stack to substitute function stack
        Stack<Map<String, Integer>> quickSortStack = new Stack<>();
        // use map to save index{startIndex, endIndex}
        Map rootParam = new HashMap();
        rootParam.put("startIndex", startIndex);
        rootParam.put("endIndex", endIndex);
        quickSortStack.push(rootParam);

        while (!quickSortStack.empty()) {
            Map<String, Integer> param = quickSortStack.pop();

            int pivotIndex = quickSortSwithPointersPartition(nums, param.get("startIndex"), param.get("endIndex"));

            if (param.get("startIndex") < pivotIndex-1) {
                Map<String, Integer> leftParam = new HashMap<>();
                leftParam.put("startIndex", param.get("startIndex"));
                leftParam.put("endIndex", pivotIndex-1);
                quickSortStack.push(leftParam);
            }

            if (param.get("endIndex") > pivotIndex + 1) {
                Map<String, Integer> rightParam = new HashMap<>();
                rightParam.put("startIndex", pivotIndex+1);
                rightParam.put("endIndex", param.get("endIndex"));
                quickSortStack.push(rightParam);
            }
        }
    }

    /**
     *  l is left bound, r is right bound
     *  Attention: privot num should be nums[l], instead of nums[0](range changes in the whole process)
     * @param nums
     * @param l 
     * @param r
     * @return
     */
    private int quickSortSwithPointersPartition(int[] nums, int l, int r) {
        int privot = nums[l];
        int i = l, j = r;
        while (i != j) {
            while (i < j && nums[j] > privot) {
                j--;
            }

            while (i < j && nums[i] <= privot) {
                i++;
            }

            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        nums[l] = nums[i];
        nums[i] = privot;

        return i;
    }


    public static void main(String[] args) {
        new QuickSort().test();
    }
}

/*
    快速排序递归排序指定一个位置并选取该位置元素为标准遍历区间将大于小于该数的元素分别置于两端
 */