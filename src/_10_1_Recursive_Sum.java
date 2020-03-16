/**
 * Created by ua28 on 3/16/20.
 */
public class _10_1_Recursive_Sum {

    /**
     * add From n to 1
     * @param n
     * @return
     */
    private int sum1ToN(int n) {
        if (n <= 1)
            return 1;

        return sum1ToN(n-1)+n;
    }

    public static void main(String[] args) {
        System.out.println(new _10_1_Recursive_Sum().sum1ToN(100));
    }
}
