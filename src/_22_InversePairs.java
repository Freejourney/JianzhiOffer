import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by ua28 on 5/1/20.
 */
public class _22_InversePairs {

    private int[] arr = {7, 5, 6, 4};

    /**
     * Time Complex Degree: O(n^2)
     * just traverse all of them
     * @return
     */
    public int findInversePaires_1() {
        Set<String> set = new HashSet<>();
        int num = 0;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    String tmp = arr[i]+"-"+arr[j];
                    if (!set.contains(tmp)) {
                        set.add(tmp);
                        num++;
                    }
                }
            }
        }
        return num;
    }

    public void test() {
        System.out.println(findInversePaires_1());
    }

    public static void main(String[] args) {
        new _22_InversePairs().test();
    }
}
