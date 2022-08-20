package Telsa.three;

public class Main {
    public static void main(String[] args) {
        String s = "RWWRWWRWW";
        sort(s);

    }

    public static void sort(String s) {
        char[] str = s.toCharArray();
        int index = str.length/2;
        int rightW = 0;
        int rightR = 0;
        int leftW = 0;
        int leftR = 0;
        for(int i = index; i < str.length; i++) {
            if(str[i] == 'W') {
                rightR++;
            } else {
                rightW++;
            }
        }
        for(int i = index-1; i >= 0; i--) {
            if(str[i] == 'W') {
                leftW++;
            } else {
                leftR++;
            }
        }



    }
}
