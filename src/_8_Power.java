/**
 * Created by ua28 on 3/14/20.
 */
public class _8_Power {

    public double power(double base, int exponent) {
        if (base == 0)
            return 0;

        if (exponent == 0)
            return 1;

        double result = 1;

        for (int i = 0; i < Math.abs(exponent); i++)
            result *= base;

        // for exponent smaller than 0, we should make base to be 1/base and get opposite number of exponent
        if (exponent < 0)
            return 1/result;

        return result;
    }

    public void test() {
        System.out.println("-3^3="+power(-0.3, -3));
        System.out.println("0^0="+power(0, 0));
        System.out.println("n^0="+power(-1.23, 0));
    }

    public static void main(String[] args){
        new _8_Power().test();
    }
}
