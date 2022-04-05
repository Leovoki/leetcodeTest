package 剑指offer_5;

public class Solution {
    public static void main(String[] args) {
        String s = "We are happy.";
        replaceSpace(s);
    }

    public static String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                sb.append("  ");
            }
        }
        if (sb.length() == 0) {
            return s;
        }


        int fast = s.length() - 1;//原末尾
        s = s + sb.toString();//拥有新长度的string
        int slow = s.length() - 1;//新末尾
        char[] str = s.toCharArray();
        while (fast >= 0) {
            if (str[fast] == ' ') {
                str[slow--] = '0';
                str[slow--] = '2';
                str[slow] = '%';//最后还有一次--
            } else {
                str[slow] = str[fast];
            }
            slow--;
            fast--;
        }

        return new String(str);
    }

}
