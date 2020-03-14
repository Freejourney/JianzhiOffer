import java.util.Arrays;

/**
 * Created by ua28 on 3/14/20.
 */
public class _9_One2N {

    private int line = 50;

    public void printNums(int n) {
        if (n <= 0)
            return;

        char[] num = new char[n];
        Arrays.fill(num, '0');

        int t = 0;
        while (!Increment(num)) {
            t++;
            printResult(num);
            if (t == line) {
                t = 0;
                System.out.println();
            }
        }
    }

    private boolean Increment(char[] num) {
        boolean isOverflow = false;
        int nTakeOver = 0;

        for (int i = num.length-1; i>=0; i--) {
            int nSum = num[i] - '0' + nTakeOver;

            // increase from last element
            if (i == num.length-1) {
                nSum++;
            }

            // for takeover case
            if (nSum >= 10) {

                // overflow
                if (i == 0) {
                    isOverflow = true;
                } else {
                    // delivery takeover
                    nSum -= 10;
                    nTakeOver = 1;
                    num[i] = (char) ('0' + nSum);
                }
            } else {
                num[i] = (char) ('0' + nSum);
                // for the previous numbers, it's unnecessary to change now(cause no takeover)
                break;
            }
        }
        return isOverflow;
    }

    private void printResult(char[] num) {
        boolean afterZero = false;
        for (int i = 0; i < num.length; i++) {
            if (num[i] != '0')
                afterZero = true;
            if (afterZero)
                System.out.print(num[i]);
        }
        System.out.print("\t");
    }

    public void test() {
        printNums(4);
    }

    public static void main(String[] args) {
        new _9_One2N().test();
    }
}
