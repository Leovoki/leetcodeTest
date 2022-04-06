import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while(cin.hasNextLine()) {
            String[] str = cin.nextLine().split(" ");
            int[] nums = new int[str.length];
            for(int i = 0; i < str.length; i++) {
                nums[i] = Integer.parseInt(str[i]);
            }
            for(int i = 0; i < 3; i++) {
                System.out.printf("您是今天%d,第%d位客人\n",nums[i],nums[i]);
            }
        }
    }
}
