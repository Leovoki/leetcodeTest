package Unity;

public class temp {


    public boolean isValidString (String s) {
        char[] str = s.toCharArray();
        int cnt = 0;
        int xing = 0;
        for(int i = 0; i < s.length(); i++) {
            if(cnt < 0) {
                break;
            }
            if(cnt <= 0 && xing > 0) {
                break;
            }
            if(str[i] == '(') {
                cnt++;
            } else if(str[i] == ')') {
                cnt--;
            } else {
                xing++;
            }
        }
        if(cnt - xing == 0) {
            return true;
        } else {
            return false;
        }
    }
}
