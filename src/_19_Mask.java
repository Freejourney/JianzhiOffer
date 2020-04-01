import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by ua28 on 4/1/20.
 */
public class _19_Mask {

    public void test() {
        Scanner sc = new Scanner(System.in);

        int[] w = new int[]{2, 2, 3, 1, 5, 2};
        int[] v = new int[]{2, 3, 1, 5, 4, 3};
        int[] dp = new int[20];

        Arrays.fill(dp, 0);

        int N = sc.nextInt();
        // i对应6个商品，分别计算N元以内能买到的所有物品
        // 如果物品只有1个的话，i<1，只有一种商品，同理有两个物品的话，i<2计算2个商品的情况
        for (int i = 0; i < 6; i++) {
            // j从给定资金开始向前回退，比如 j=14的话，当前获取的价值可能是 j=12的价值(dp[12])加上花了2元(w[i])后获得的价值v[i]
            // 最终得到的dp矩阵将会是针对所有商品的，资金从0到N所能买到的最大价值
            for (int j = N; j >= w[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j-w[i]]+v[i]);
            }
        }

        System.out.println(dp[N]);
    }

    public static void main(String[] args){
        new _19_Mask().test();
    }
}
