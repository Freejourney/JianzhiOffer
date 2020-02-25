package SortMethods.Type2;

import java.util.Arrays;

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

        int[] array2 = new int[] {7, 1, 3, 10, 5, 2, 8, 9, 6};
        new BinaryHeap().buildHeap(array2);
        System.out.println(Arrays.toString(array2));
    }
}
