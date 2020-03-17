/**
 * Created by ua28 on 3/17/20.
 */
public class _12_CountOne {

    public int countOne(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((n & flag)!= 0)
                count++;
            flag = flag << 1;
        }

        return count;
    }

    public int countOneI(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n-1);
            count++;
        }
        return count;
    }

    public void test() {
        System.out.println(countOne(1010));

        System.out.println(countOne(11));
    }

    public static void main(String[] args) {
        new _12_CountOne().test();
    }
}
