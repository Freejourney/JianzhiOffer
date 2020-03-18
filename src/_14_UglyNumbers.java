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
    }

    public static void main(String[] args) {
        new _14_UglyNumbers().test();
    }
}
