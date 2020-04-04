import java.util.*;

/**
 * Created by ua28 on 3/29/20.
 */
public class _18_MinKNum {

    /**
     * 时间复杂度为O(kn), 空间复杂度为O(1)
     * 每次从剩余的序列中寻找最小的数，采用集合来过滤掉已经选取过得元素下标
     * @param arr
     * @param k
     * @return
     */
    public int[] minKNum_onebyone(int[] arr, int k) {
        Set<Integer> set = new HashSet<>();

        for (int j = 0; j < k; j++) {
            int t = 0;
            // 从未选取过的第一个下标开始
            while (set.contains(t))
                t++;
            int min = arr[t];
            int index = t;
            for (int i = 0; i < arr.length; i++) {
                if (min > arr[i]) {
                    // 仅对为选取过的元素进行比较
                    if (!set.contains(i)) {
                        min = arr[i];
                        index = i;
                    }
                }
            }
            set.add(index);
        }

        // 将集合添加到数组中去
        int[] result = new int[k];
        int t = 0;
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            int i = iterator.next();
            result[t++] = arr[i];
        }
        return result;
    }

    public void test() {
        int[] arr = new int[]{4, 5, 1, 1, 0, 6, 6, 2, 7, 3, 8};
        int k = 9;

        int[] result = minKNum_onebyone(arr, k);
        Arrays.sort(result);
        for (int e : result)
            System.out.print(e+" ");
    }

    public static void main(String[] args) {
        new _18_MinKNum().test();
    }
}
