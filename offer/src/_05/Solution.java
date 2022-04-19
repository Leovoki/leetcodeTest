package _05;

public class Solution {
    public static void main(String[] args) {
        String s = "We are happy.";
        replaceSpace(s);
    }

    public static String replaceSpace(String s) {
        //首先看有多少个空格，判断需要加长多少
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
                sb.append("  ");
            }
        }
        if(sb.length() == 0) {
            return s;//说明没有空格
        }

        String str = s + sb.toString();//新数组的长度
        char[] strs = str.toCharArray();
        int fast = s.length()-1;//指向原数组末尾
        int slow = str.length() - 1;//新数组末尾
        for(fast = fast; fast >=0;) {
            if(strs[fast--] == ' ') {
                //如果是空格，则开始插入
                strs[slow--] = '0';
                strs[slow--] = '2';
                strs[slow--] = '%';
            } else {
                //普通
                strs[slow--] = strs[fast--];
            }
            //fast--;
        }
        return new String(strs);
    }
}
