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
        additionOnString(8);
    }

    public static void main(String[] args) {
        new AdditionOnStringAndArray().test();
    }
}
