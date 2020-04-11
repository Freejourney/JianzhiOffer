/**
 * Created by ua28 on 4/11/20.
 * 现给定任意正整数 n，请寻找并输出最小的正整数 m（m>9），使得 m 的各位（个位、十位、百位 ... ...）之乘积等于n，若不存在则输出 -1。
 */
public class _20_FindMinCombinedNum {

    public int solution(int num) {
        int res = helper(num);
        return res > 0 ? res : -1;
    }

    private int helper(int num) {
        if (num <= 9)
            return num;
        // 从大到小分解num，将最大的因子放在低位
        for (int i = 9; i > 1; i--) {
            if (num%i == 0) {
                return helper(num/i)*10+i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int num = 35;
        System.out.println(new _20_FindMinCombinedNum().solution(num));
    }
}
