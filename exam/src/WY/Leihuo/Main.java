package WY.Leihuo;

import java.util.*;

public class Main {
    private static List<Project> result = null;
    private static Boolean find = false;
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        List<Project> list = new ArrayList<>();
        String[] s = cin.nextLine().split(" ");
        //cin.nextInt();
        int seq = 0;
        for(String str : s) {
            String[] p = str.split(",");
            Project project = new Project();
            project.setDays(Integer.parseInt(p[0]));//天数
            project.setImportant(Integer.parseInt(p[1]));//重要度
            project.setRate();
            project.setSeq(seq++);
            list.add(project);
        }
        //这是一道DP
        int[][] dp = new int[list.size()][21];
        //从0~i个项目中选，塞满容量为20的背包，能够获得的最大重要比是多少

        //初始化
        for(int i = list.get(0).days; i <= 20; i++) {
            dp[0][i] = list.get(0).important;
        }
        for(int i = 1; i < list.size(); i++) {
            for(int j = 20; j >=list.get(i).days ;j--) {
                int one = dp[i-1][j-list.get(i).days] + list.get(i).important;
                int two = dp[i-1][j];
                dp[i][j] = Math.max(one,two);
            }
        }
        int ans = dp[list.size()-1][20];
        //System.out.println(dp[list.size()-1][20]);
        findAns(ans,20, list,0);
        for(int i = 0; i < result.size(); i++) {
            Project project = result.get(i);
            if(project.isDo) {
                System.out.printf("1");
            } else {
                System.out.printf("0");
            }
            if(i != result.size()-1) {
                System.out.printf(" ");
            }
        }





    }

    public static void findAns(int ans, int days, List<Project> projects, int startIndex) {
        if(ans == 0 && days >= 0) {
            result = new ArrayList<>(projects);
            find = true;
            return;
        } else if (days < 0 || ans < 0) {
            return;
        }
        for(int i = startIndex; i < projects.size(); i++) {
            Project project = projects.get(i);
            project.setDo(true);
            findAns(ans-project.important,days-project.days ,projects, i+1);
            if(find) {
                return;
            }
            project.setDo(false);
        }
    }
}

class Project {
    int days;
    int important;
    double rate;
    boolean isDo = false;
    int seq;

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public void setDo(boolean isDo) {
        this.isDo = isDo;
    }


    public void setDays(int days) {
        this.days = days;
    }

    public void setImportant(int important) {
        this.important = important;
    }

    public void setRate() {
        this.rate = days / important;
    }
}
