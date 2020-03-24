/**
 * Created by ua28 on 3/24/20.
 */
public class _17_OrderStr {

    private int count = 0;

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
            System.out.println(++count);
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

    /**
     * 每个字符取或是不取
     * @param chars
     * @param begin
     * @param len
     * @param sb
     */
    public static void combinate(char[] chars,int begin,int len,StringBuffer sb){
        // 长度取满
        if(len==0){
            System.out.println(sb);
            return;
        }
        // 什么都不取
        if(begin==chars.length)
            return;

        sb.append(chars[begin]);   //取当前字符
        combinate(chars,begin+1,len-1,sb);

        sb.deleteCharAt(sb.length()-1);  //不取当前字符
        combinate(chars,begin+1,len,sb);
    }

    public void test() {
        orderStr(new char[]{'a', 'b', 'c'});

        String str="abc";
        char[] chars=str.toCharArray();
        StringBuffer sb=new StringBuffer();
        for(int i=1;i<=str.length();i++){
            combinate(chars,0,i,sb);
        }
    }

    public static void main(String[] args) {
        new _17_OrderStr().test();
    }
}
