import java.util.*;

public class TU {
    public static void main(String[] args) {
        solution("foo(bar)baz");
    }
    // 本题面试官已设置测试用例
    public static String solution(String inputString) {
        // 在这⾥写代码
        Scanner cin = new Scanner(System.in);
        String s = cin.next();
        char[] str = s.toCharArray();
        List<Character> result = new ArrayList<>();
        Deque<Character> stack = new LinkedList<>();
        for(int i = 0; i < str.length; i++) {
            if(str[i] != ')') {
                //不需要弹出
                stack.offerFirst(str[i]);
            } else {
                //需要弹出塞入
                parse(stack);
            }
        }
        while(!stack.isEmpty()) {
            System.out.println(stack.pollFirst());
        }
        return " ";
    }

    public static void parse(Deque<Character> stack) {
        //这里是将（前的字符全部弹出，然后按照顺序压进去
        List<Character> temp = new ArrayList<>();
        while(stack.peekFirst() != '(') {
            temp.add(stack.pollFirst());
        }
        stack.pollFirst();//弹出（
        for(int i = 0; i < temp.size(); i++) {
            stack.offerFirst(temp.get(i));
        }



    }

    public Character[] reverse(Character[] chars) {
        int front = 0;
        int end = chars.length-1;
        for(front = 0; front < end; front++) {
            Character temp = chars[front];
            chars[front] = chars[end];
            chars[end--] = temp;
        }
        return chars;
    }
}
