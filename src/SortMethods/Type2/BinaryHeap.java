package SortMethods.Type2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ua28 on 2/25/20.
 */
public class BinaryHeap {

    public void upAdjust(int[] array) {
        int childIndex = array.length - 1;
        int parentIndex = (childIndex - 1) / 2;

        int temp = array[childIndex];
        while (childIndex > 0 && temp < array[parentIndex]) {
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (parentIndex - 1) / 2;
        }
        array[childIndex] = temp;
    }

    public void upAdjust_(int[] array) {
        int childIndex = array.length - 1;
        int parentIndex = (childIndex - 1) / 2;
        int temp = array[childIndex];
        while (childIndex > 0) {
            if (array[parentIndex] < temp) {
                break;
            }
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (parentIndex - 1)/2;
        }
        array[childIndex] = temp;
    }

    public void downAdjust(int[] array, int parentIndex, int length) {
        int temp = array[parentIndex];
        int childIndex = 2 * parentIndex + 1;
        while (childIndex < length) {
            if (childIndex + 1 < length && array[childIndex + 1] < array[childIndex]) {
                childIndex ++;
            }
            if (temp <= array[childIndex])
                break;
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * parentIndex + 1;
        }
        array[parentIndex] = temp;
    }

    public void buildHeap(int[] array) {
        for (int i = array.length / 2; i >= 0; i--) {
            downAdjust(array, i, array.length-1);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[] {1, 3, 2, 6, 5, 7, 8, 9, 10, 0};
        new BinaryHeap().upAdjust(array);
        System.out.println(Arrays.toString(array));

        int level = getLevels(array.length);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int num = 0;
        int expectedNum = 1;
        while (!queue.isEmpty()) {
            int index = queue.remove();
            System.out.print(array[index]+"  ");
            num++;
            if (2*index+1 < array.length)
                queue.add(2*index+1);
            if (2*index+2 < array.length)
                queue.add(2*index+2);
            if (num == expectedNum) {
                System.out.println();
                expectedNum *= 2;
                num = 0;
            }
        }
        System.out.println();

        int[] array2 = new int[] {7, 1, 3, 10, 5, 2, 8, 9, 6};
        new BinaryHeap().buildHeap(array2);

        System.out.println(Arrays.toString(array2));
        Queue<Integer> queue2 = new LinkedList<>();
        queue2.add(0);
        int nums = 0;
        int expectedNum2 = 1;
        while (!queue2.isEmpty()) {
            int index = queue2.remove();
            System.out.print(array2[index]+"  ");
            nums++;
            if (2*index+1 < array2.length)
                queue2.add(2*index+1);
            if (2*index+2 < array2.length)
                queue2.add(2*index+2);
            if (nums == expectedNum2) {
                expectedNum2 *= 2;
                nums = 0;
                System.out.println();
            }
        }
    }

    public static int getLevels(int length) {
        if (length <= 0)
            return 0;
        int level = 1;
        while (length != 1) {
            length /= 2;
            level++;
        }
        return level;
    }
}
