/**
 * Created by ua28 on 4/11/20.
 * 在vivo产线上，每位职工随着对手机加工流程认识的熟悉和经验的增加，日产量也会不断攀升。
 假设第一天量产1台，接下来2天(即第二、三天)每天量产2件，接下来3天(即第四、五、六天)每天量产3件 ... ...
 以此类推，请编程计算出第n天总共可以量产的手机数量。
 */
public class _21_NumOfPhone {

    /**
     * 模拟整个增长过程
     * @param n
     * @return
     */
    int solution(int n) {
        int prelength = 1;
        int length = 1;
        int numPerDay = 1;
        int sum = 0;
        for (int day = 1; day <= n; day++) {
            sum += numPerDay;
            length--;
            if (length == 0) {
                prelength++;
                length = prelength;
                numPerDay++;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.print(new _21_NumOfPhone().solution(100));
    }
}
