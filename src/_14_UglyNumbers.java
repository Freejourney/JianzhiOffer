/**
 * Created by ua28 on 3/18/20.
 */
public class _14_UglyNumbers {

    /**
     * Traverse to find nth ugly number
     * @param n
     * @return
     */
    public int getNthUglyNumber(int n) {
        if (n <= 0)
            return -1;

        int number = 0;
        int uglyFound = 0;
        while (uglyFound < n) {
            ++number;
            if (isUglyNumbers(number))
                uglyFound++;
        }

        return number;
    }

    /**
     * a ugly number multiplies 2, 3, 5 is still a ugly number
     * calculate every ugly number from 1th to nth
     * @param n
     * @return
     */
    public int getNthUglyNumber_FromDownToUp(int n) {
        if (n <= 0)
            return -1;

        int[] uglyNumbers = new int[n];
        uglyNumbers[0] = 1;
        int nextUglyNumber = 1;

        int pMultiply2 = 0, pMultiply3 = 0, pMultiply5 = 0;

        while (nextUglyNumber < n) {
            int min = Min(uglyNumbers[pMultiply2]*2, uglyNumbers[pMultiply3]*3, uglyNumbers[pMultiply5]*5);
            uglyNumbers[nextUglyNumber] = min;

            while (uglyNumbers[pMultiply2]*2 <= uglyNumbers[nextUglyNumber])
                ++pMultiply2;
            while (uglyNumbers[pMultiply3]*3 <= uglyNumbers[nextUglyNumber])
                ++pMultiply3;
            while (uglyNumbers[pMultiply5]*5 <= uglyNumbers[nextUglyNumber])
                ++pMultiply5;

            nextUglyNumber++;
        }

        return uglyNumbers[nextUglyNumber-1];
    }

    private int Min(int num1, int num2, int num3) {
        if (num1 < num2) {
            return num1 < num3 ? num1 : num3;
        }
        return num2 < num3 ? num2 : num3;
    }

    /**
     * constantly divide certain factors until number becomes 1
     * @param number
     * @return
     */
    public boolean isUglyNumbers(int number) {
        while (number % 2 == 0)
            number /= 2;
        while (number % 3 == 0)
            number /= 3;
        while (number % 5 == 0)
            number /= 5;
        return number == 1 ? true : false;
    }

    public void test() {
        System.out.println(getNthUglyNumber(1500));
        System.out.println(getNthUglyNumber_FromDownToUp(1500));
    }

    public static void main(String[] args) {
        new _14_UglyNumbers().test();
    }
}
