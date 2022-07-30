package PreBatch.XingHuan.THREE;

import com.sun.crypto.provider.HmacPKCS12PBESHA1;

import java.util.*;

public class Main {
    private static Map<String, Integer> map = new HashMap<>();
    private static Map<String, Integer> numMap = new HashMap<>();
    static {
        map.put("is not null",6);
        map.put("is null", 6);
        map.put(">", 5);
        map.put("<",5);
        map.put("=",5);
        map.put("and",4);
        map.put("or",3);
        map.put("*", 2);
        map.put("+",1);
        map.put("(",0);

        numMap.put("false",0);
        numMap.put("true",1);
    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();//变量个数
        cin.nextLine();
        Map<String, String> v = new HashMap<>();
        while(n-- > 0) {
            String[] s = cin.nextLine().split(" ");
            v.put(s[0],s[1]);
        }//变量获取
        n = cin.nextInt();//总共几对式子
        while(n-- > 0) {
            cin.nextLine();
            String s = cin.nextLine();
            List<String> cal = getSub(s, v);
            if(cal.get(0).equals("Error")) {
                System.out.println("Error");
                continue;
            }
            //开始计算
            String result = getResult(cal);
            System.out.println(result);

        }
    }

    public static String getResult(List<String> list) {
        Deque<String> que = new LinkedList<>();
        for(String s : list) {
            if(isNumber(s) || s.equals("false") || s.equals("true") || s.equals("null")) {
                //说明是变量
                que.offerFirst(s);
            } else {
                //运算符
                String first = que.pollFirst();
                String second = que.pollFirst();
                if(s.equals("and")) {
                    if(first.equals("null") || second.equals("null")) {
                        que.offerFirst("null");
                    } else if(isNumber(first) && isNumber(second)) {
                        if(Integer.parseInt(first) == 0 || Integer.parseInt(second) == 0) {
                            que.offerFirst("false");
                        } else {
                            que.offerFirst("true");
                        }
                    } else if(first.equals("false") || second.equals("false")) {
                        que.offerFirst("false");
                    }
                } else if (s.equals("or")) {
                    if(isNumber(first) && isNumber(second)) {
                        if(Integer.parseInt(first) == 0 && Integer.parseInt(second) == 0) {
                            que.offerFirst("false");
                        } else {
                            que.offerFirst("true");
                        }
                    } else if(first.equals("true") || second.equals("true")) {
                        que.offerFirst("true");
                    } else {
                        que.offerFirst("false");
                    }
                } else if(s.equals("<") || s.equals(">") || s.equals("=")) {
                    que.offerFirst(String.valueOf(second.compareTo(first)));
                } else if(s.equals("is null")) {
                    que.offerFirst(second);
                    if(first.equals("null")) {
                        que.offerFirst("true");
                    } else {
                        que.offerFirst("false");
                    }
                } else {
                    que.offerFirst(second);
                    if(first.equals("null")) {
                        que.offerFirst("false");
                    } else {
                        que.offerFirst("true");
                    }
                }
            }
        }
        if(que.size() != 1) {
            return "Error";
        } else {
            return que.pollFirst();
        }
    }


    public static List<String> getSub(String s, Map<String, String> v) {
        String[] str = s.split(" ");
        List<String> list = new ArrayList<>();//后缀表达式
        Deque<String> que = new LinkedList<>();//辅助栈
        int size = str.length;
        for(int i = 0; i < size; i++) {
            //判断是不是变量或者数字
            if(str[i].compareTo("z") <= 0 && str[i].compareTo("a") >= 0) {
                //说明是变量
                list.add(v.get(str[i]));
            } else if (str[i].equals("(")) {
                que.offerFirst(str[i]);
            } else if (str[i].equals(")")) {
                while(!que.peekFirst().equals("(")) {
                    list.add(que.pollFirst());
                }
                que.pollFirst();//把左括号弹出
            } else if (str[i].equals("is")) {
                //判断是is null 还是is not null
                if(str[i+1].equals("null")) {
                    que.offerFirst("is null");//最大无脑压栈
                    i = i + 1;//会自动i++
                } else if (str[i+1].equals("not") && str[i+2].equals("null")) {
                    que.offerFirst(("is not null"));
                    i = i + 2;
                } else {//不合法输入
                    list.set(0,"Error");
                    break;
                }
            } else if(str[i].equals("<") || str[i].equals(">") || str[i].equals("=") ) {
                //除非遇到 null或者空栈
                while(!que.isEmpty() && (que.peekFirst().equals("is null") || que.peekFirst().equals("is not null"))) {
                    //只要是比你大的，就出栈
                    list.add(que.pollFirst());
                }
                que.offerFirst(str[i]);
            } else if(str[i].equals("and")) {
                while(!que.isEmpty() && (map.get("and") < map.get(que.peekFirst()))) {
                    //比你大
                    list.add(que.pollFirst());
                }
                que.offerFirst(str[i]);
            } else if (str[i].equals("or")) {
                while(!que.isEmpty() && (map.get("or") < map.get(que.peekFirst()))) {
                    list.add(que.pollFirst());
                }
                que.offerFirst(str[i]);
            } else if (str[i].equals("*")) {
                while(!que.isEmpty() && (map.get("*") < map.get(que.peekFirst()))) {
                    list.add(que.pollFirst());
                }
                que.offerFirst(str[i]);
            } else if (str[i].equals("+")) {
                while(!que.isEmpty() && (map.get("+") < map.get(que.peekFirst()))) {
                    list.add(que.pollFirst());
                }
                que.offerFirst(str[i]);
            } else if (str[i].equals("false") || str[i].equals("true") || str[i].equals("null")) {
                //其它变量
                list.add(str[i]);
            } else if(isNumber(str[i])) {
                //如果是数字变量
                list.add(str[i]);
            } else {
                //什么都是不是
                if(list.isEmpty()) {
                    list.add("Error");
                    break;
                }
                list.set(0,"Error");
                break;
            }
        }
        //此时中缀表达式遍历完毕，弹出所有运算符
        while(!que.isEmpty()) {
            list.add(que.pollFirst());
        }
        return list;
    }

    public static boolean isNumber(String s) {
        try {
            Integer.parseInt(s);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
