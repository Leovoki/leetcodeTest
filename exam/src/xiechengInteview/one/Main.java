package xiechengInteview.one;

public class Main {
    public static void main(String[] args) {
        String s = "hello word apple";
        char[] str = s.toCharArray();
        int front = 0;
        int end = str.length-1;
        reverse(front, end, str);
        front = 0;
        for(int i = 0; i < str.length; i++) {
            if(str[i] == ' ') {
                //遇到空格
                reverse(front, i-1, str);
                front = i+1;
            }
        }
        //最后一组
        reverse(front, str.length-1, str);

        for(int i = 0; i < str.length; i++) {
            System.out.print(str[i]);
        }
    }

    public static void reverse(int front, int end, char[] str) {
        for(front = front; front < end;) {
            char temp = str[front];
            str[front] = str[end];
            str[end] = temp;
            front++;
            end--;
        }
    }
}
