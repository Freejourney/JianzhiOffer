public class _5_SubstituteSpace extends Tools{
    private String mStr = "We are happy";
    private char[] str = {'W', 'e', ' ', 'a', 'r', 'e', ' ', 'h', 'a', 'p', 'p', 'y', '.', '\0', '$', '$', '$', '$', '$'};

    public void SubstiStrSpace_1_DirectScan() {
        String tmp = "";
        for (int i = 0; i < mStr.length(); i++) {
            if (mStr.charAt(i) != ' ') {
                tmp += mStr.charAt(i);
            } else {
                tmp += "%20";
            }
        }

        int num = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == ' ')
                num++;
        }

        char[] newstr = new char[str.length+2*num];
        int j = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] != ' ') {
                newstr[j] = str[i];
            } else {
                newstr[j] = '%';
                newstr[j+1] = '2';
                newstr[j+2] = '0';
                j += 2;
            }
            j++;
        }

        System.out.println(tmp);
        ShowArray(newstr);
        System.out.println(mStr.length());
    }

    public void SubstiStrSpace_2_NoExtraSpace(String target) {
        if (str == null || str.length ==0) {
            return;
        }

        int length = 0;
        while (str[length] != '\0')
            length++;
        length++;
        int p1 = length - 1;

        int count = 0;
        for (int i = 0; i < str.length; i++)
            if (str[i] == ' ')
                count++;
        int p2 = count*2 + length - 1;

        while (p1 >= 0) {
            if (str[p1] != ' ') {
                str[p2] = str[p1];
                p2--;
            } else {
                for (int j = 0; j < target.length(); j++) {
                    str[p2] = target.charAt(target.length()-j-1);
                    p2--;
                }
            }
            p1--;
        }

        ShowArray(str);
    }

    public static void main(String[] args) {
        new _5_SubstituteSpace().SubstiStrSpace_1_DirectScan();
        new _5_SubstituteSpace().SubstiStrSpace_2_NoExtraSpace("%20");
    }
}

/*
    先遍历，计算最终长度
    然后双指针原数组替换
 */
