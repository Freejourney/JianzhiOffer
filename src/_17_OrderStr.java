/**
 * Created by ua28 on 3/24/20.
 */
public class _17_OrderStr {

    public void orderStr(char[] str) {
        if (str == null)
            return;

        orderStr(str, 0);
    }

    /**
     * 全排列：n*(n-1)*(n-2) ... *2*1
     *
     * @param str
     * @param begin
     */
    private void orderStr(char[] str, int begin) {
        if (begin >= str.length) {
            for (char ch : str)
                System.out.print(ch+" ");
            System.out.println();
        }

        // 模拟全排列选择过程
        // 采用交换的方式来实现原地选择，选择后还原数组
        for (int i = begin; i < str.length; i++) {
            char temp = str[i];
            str[i] = str[begin];
            str[begin] = temp;

            orderStr(str, begin+1);

            temp = str[i];
            str[i] = str[begin];
            str[begin] = temp;
        }
    }

    public void test() {
        orderStr(new char[]{'a', 'b', 'c'});
    }

    public static void main(String[] args) {
        new _17_OrderStr().test();
    }
}
