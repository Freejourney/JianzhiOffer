/**
 * Created by ua28 on 3/17/20.
 */
public class _12_CountOne {

    /**
     * 将1左移，分别对应n的每一位直到溢出
     * 避免对n右移时n为负数前面添1导致无限循环
     * @param n
     * @return
     */
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

    /**
     * 把一个整数减1，再和原整数做与运算，会把该整数最右边的1变成0
     * @param n
     * @return
     */
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

        //负数二进制前面补1
        int a = -10;
        a = a >> 1;
        System.out.println(Integer.toBinaryString(a));
    }

    public static void main(String[] args) {
        new _12_CountOne().test();
    }
}
