import java.util.Arrays;

/**
 * Created by ua28 on 4/4/20.
 */
public class _64_AddFrom1toN {

    public int getAddFrom1toN_I(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++)
            sum += i;
        return sum;
    }

    public int getAddFrom1toN_II(int n) {
        return n*(1+n)/2;
    }

    public String getAddFrom1toN_III(char[] n) {
        
        char[] sum = new char[]{'0'};
        char[] tmp = new char[]{'1'};

        while (!isEqual(tmp, n)) {
            increaseTmp(tmp);
//            addToSum(sum, tmp);
        }

        return String.valueOf(sum);
    }

    /**
     * Java中传递的是数据地址的引用，指向原数组同一地址(原引用与参数引用均指向同一地址)，
     * 所以当函数内的数组发生变化时，原数组并不能随之改变，而应当按返回值去改变原数组引用。
     *
     * 在扩容的时候tmp发生了变化
     * @param tmp
     * @return
     */
    private char[] increaseTmp(char[] tmp) {
        int tmp_last_result = tmp[tmp.length-1]-'0'+1;
        int carry = 0;
        if (tmp_last_result >= 10) {
            carry = tmp_last_result/10;
            tmp_last_result -= 10;
        }
        tmp[tmp.length-1] = (char) (tmp_last_result+'0');

        int index = tmp.length-1;
        while (carry != 0) {
            if (index == 0) {
                tmp = copyTmpToNew(tmp);
                index = 1;
            }
            index--;
            tmp_last_result = tmp[index]-'0'+carry;
            carry = 0;
            if (tmp_last_result >= 10) {
                carry = tmp_last_result/10;
                tmp_last_result -= 10;
            }
            tmp[index] = (char)(tmp_last_result+'0');
        }

        return tmp;
    }

    /**
     * Java中传递的是数据地址的引用，指向原数组同一地址(原引用与参数引用均指向同一地址)，
     * 所以当函数内的数组发生变化时，原数组并不能随之改变，而应当按返回值去改变原数组引用。
     *
     * 在扩容的时候tmp发生了变化, tmp -> result
     * @param tmp
     * @return
     */
    private char[] copyTmpToNew(char[] tmp) {
        char[] result = new char[tmp.length+1];
        Arrays.fill(result, '0');

        for (int i = 1; i < result.length; i++)
            result[i] = tmp[i-1];
        return result;
    }

    private boolean isEqual(char[] tmp, char[] n) {
        return String.valueOf(tmp).equals(String.valueOf(n));
    }

    public void test() {
        int n = 1000;
        char[] cn = new char[]{'1', '0', '0', '0'};

//        System.out.println(getAddFrom1toN_I(n));
//        System.out.println(getAddFrom1toN_II(n));
//        System.out.println(getAddFrom1toN_III(cn));

        // increaseTmp() function test
        char[] tmp = new char[]{'0'};
        for (int i = 0; i < 1000; i++) {
            tmp = increaseTmp(tmp);
            System.out.println(String.valueOf(tmp));
        }
    }

    public static void main(String[] args) {
        new _64_AddFrom1toN().test();
    }
}
