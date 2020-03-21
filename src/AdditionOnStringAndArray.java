import java.util.Arrays;

/**
 * Created by ua28 on 3/20/20.
 */
public class AdditionOnStringAndArray {

    /**
     *  对字符串数字实现 +1
     *
     *  该过程分为两个部分：
     *          ① 最后一位加1
     *          ② 其余位的进位
     *
     *  第一步直接单独对最后一位加1，判断加1后的数字是否需要进位，进位则将carry设置为1
     *  第二步当carry不为0的时候循环第一步操作（与第一步类似）
     */
    public void addOneForAString() {
        char[] cnum = new char[]{'1', '9', '0', '9', '9'};

        // 第一步 加1
        int carry = 0;
        int lastIndex = 4;
        int temp = cnum[lastIndex] - '0' + 1;
        if (temp >= 10) {
            carry = temp / 10;
            temp -= 10;
        }
        cnum[lastIndex] = (char) (temp + '0');

        // 第二步 进位
        while (carry != 0) {
            lastIndex--;
            int t = cnum[lastIndex]-'0'+carry;
            if (t >= 10) {
                carry = t/10;
                t -= 10;
            } else {
                carry = 0;
            }
            cnum[lastIndex] = (char) (t+'0');
        }

        print(cnum);
    }

    /**
     *  将数字字符串暴露出来
     * @param number
     */
    public void addOneForAString(char[] number) {
        // 第一步 加1
        int carry = 0;
        int lastIndex = number.length-1;
        int temp = number[lastIndex] - '0' + 1;
        if (temp >= 10) {
            carry = temp / 10;
            temp -= 10;
        }
        number[lastIndex] = (char) (temp + '0');

        // 第二步 进位
        while (carry != 0) {
            lastIndex--;
            int t = number[lastIndex]-'0'+carry;
            if (t >= 10) {
                carry = t/10;
                t -= 10;
            } else {
                carry = 0;
            }
            number[lastIndex] = (char) (t+'0');
        }
    }

    /**
     * 循环调用+1函数来实现迭代
     * @param n
     */
    public void additionOnString(int n) {
        char[] number = new char[n];

        Arrays.fill(number, '0');

        for (int i = 0; i < 1000; i++) {
            addOneForAString(number);
        }

        print(number);
    }

    /**
     * 实现了超过两位数的加法运算
     */
    public void additionNumberMoreThanTwo_1() {
        char[] cnum1 = new char[]{'1', '2', '3'};
        char[] cnum2 = new char[]{'2', '2'};

        int lastIndex1 = cnum1.length-1;
        int lastIndex2 = cnum2.length-1;

        int len = lastIndex1 > lastIndex2 ? lastIndex1+1 : lastIndex2+1;

        // 用额外空间暂存
        char[] result = new char[len];

        Arrays.fill(result, '0');

        int lastIndexR = len-1;

        // 第一步：计算最后一位（不用考虑进位）
        result[lastIndexR] = (char) (cnum1[lastIndex1] + cnum2[lastIndex2] - '0');

        lastIndexR--;
        lastIndex1--;
        lastIndex2--;

        // 第二步：计算其余位
        result[lastIndexR] = (char) (cnum1[lastIndex1] + cnum2[lastIndex2] - '0');

        for (char e : result)
            System.out.print(e);
    }

    /**
     * 实现了超过两位数的加法运算
     */
    public void additionNumberMoreThanTwo_2() {
        char[] cnum1 = new char[]{'1', '9', '8', '9'};
        char[] cnum2 = new char[]{'1', '1'};

        int lastIndex1 = cnum1.length-1;
        int lastIndex2 = cnum2.length-1;

        int carry = 0;

        int len = lastIndex1 > lastIndex2 ? lastIndex1+1 : lastIndex2+1;
        // 需要注意的是最大一位可能进位，所以长度加1
        len += 1;

        // 用额外空间暂存
        char[] result = new char[len];

        Arrays.fill(result, '0');

        int lastIndexR = len-1;

        // 第一步：计算最后一位（不用考虑进位）
        int t = (cnum1[lastIndex1] - '0' + cnum2[lastIndex2] - '0');
        if (t >= 10) {
            carry = 1;
            t -= 10;
        }
        result[lastIndexR] = (char) (t+'0');

        lastIndexR--;
        lastIndex1--;
        lastIndex2--;

        // 第二步：计算其余位
        while (carry != 0 || lastIndex1 >= 0 || lastIndex2 >= 0) {
            if (lastIndex1 >= 0 && lastIndex2 >= 0)
                t = (cnum1[lastIndex1] - '0' + cnum2[lastIndex2] - '0' + carry);
            else if (lastIndex1 >= 0 && lastIndex2 < 0)
                t = (cnum1[lastIndex1] - '0' + carry);
            else if (lastIndex2 >= 0 && lastIndex1 < 0)
                t = (cnum1[lastIndex2] - '0' + carry);
            else
                t = carry;
            if (t >= 10) {
                carry = 1;
                t -= 10;
            } else
                carry = 0;

            result[lastIndexR] = (char) (t+'0');

            lastIndexR--;
            lastIndex1--;
            lastIndex2--;
        }

        for (char e : result)
            System.out.print(e);
        System.out.println();

        print(result);
    }

    /**
     * 实现了超过两位数的加法运算，整理后第一步可以省略
     * @param cnum1
     * @param cnum2
     * @return
     */
    public char[] additionNumberMoreThanTwo_3(char[] cnum1, char[] cnum2) {

        int lastIndex1 = cnum1.length-1;
        int lastIndex2 = cnum2.length-1;

        int carry = 0;

        int len = lastIndex1 > lastIndex2 ? lastIndex1+1 : lastIndex2+1;
        // 需要注意的是最大一位可能进位，所以长度加1
        len += 1;
        // 用额外空间暂存
        char[] result = new char[len];

        Arrays.fill(result, '0');

        int lastIndexR = len-1;

        int t;
        // 计算每一位,将第一步省略
        while (carry != 0 || lastIndex1 >= 0 || lastIndex2 >= 0) {
            if (lastIndex1 >= 0 && lastIndex2 >= 0)
                t = (cnum1[lastIndex1] - '0' + cnum2[lastIndex2] - '0' + carry);
            else if (lastIndex1 >= 0 && lastIndex2 < 0)
                t = (cnum1[lastIndex1] - '0' + carry);
            else if (lastIndex2 >= 0 && lastIndex1 < 0)
                t = (cnum2[lastIndex2] - '0' + carry);
            else
                t = carry;
            if (t >= 10) {
                carry = 1;
                t -= 10;
            } else
                carry = 0;

            result[lastIndexR] = (char) (t+'0');

            lastIndexR--;
            lastIndex1--;
            lastIndex2--;
        }

        return result;
    }

    /**
     * 前边的0不需要打印出来
     * @param arr
     */
    public void print(char[] arr) {
        boolean flag = false;
        for (char item : arr) {
            if (item != '0')
                flag = true;
            if (flag) {
                System.out.print(item);
            }
        }
        System.out.println();
    }

    public void test() {
//        additionOnString(8);
//        additionNumberMoreThanTwo_2();
        print(additionNumberMoreThanTwo_3(new char[]{'8', '9'}, new char[]{'8', '1', '1'}));
    }

    public static void main(String[] args) {
        new AdditionOnStringAndArray().test();
    }
}
