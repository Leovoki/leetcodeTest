package offer_05;

public class ReplaceSpace {
    public static void main(String[] args)
    {
        String s = "We are happy.";
        System.out.println(replaceSpace(s));
    }

    public static String replaceSpace(String s) {
        char[] str = s.toCharArray();
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i< str.length; i++) {
            if(str[i] == ' ') {
                builder.append("%20");
                continue;
            }
            builder.append(str[i]);
        }
        return builder.toString();
    }
}
