/**
 * Created by ua28 on 3/16/20.
 */
public class _10_2_Recursive_Fibonacci {

    /**
     * All Math Expressions like this :
     *                      0               n=0,
     *              f(n) =  1               n=1,
     *                      f(n-1)+f(n-2)   n>1
     * @param n
     * @return
     */
    public long fibonacci(int n) {
        if (n <= 0)
            return 0;
        if (n == 1)
            return 1;
        return fibonacci(n-1)+fibonacci(n-2);
    }

    private void test() {
        System.out.println(fibonacci(20));
    }

    public static void main(String[] args) {
        new _10_2_Recursive_Fibonacci().test();
    }

}
