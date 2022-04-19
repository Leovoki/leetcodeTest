package WY.ONE;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int t = cin.nextInt();
        int i = 0;
        List<List<Team>> res = new ArrayList<>();
        while(t-- > 0) {
            Map<String, Team> map = new HashMap<>();
            List<Team> list = new ArrayList<>();
            for(i = 0; i <6; i++) {
                Team team = new Team(cin.next(), cin.nextInt(), cin.nextInt(), cin.nextInt());
                list.add(team);
                map.put(team.name,team);
            }
            cin.nextLine();//清除空行
            //最后一场比赛
            for(i = 0; i < 3; i++) {
                String[] prize = cin.nextLine().split(" ");
                Team teamA = map.get(prize[0]);
                Team teamB = map.get(prize[1]);
                Integer scoreA = Integer.parseInt(prize[2]);
                Integer scoreB = Integer.parseInt(prize[3]);
                teamA.setBallNum(teamA.ballNum + scoreA);
                teamA.setLostNum(teamA.lostNum + scoreB);
                teamB.setBallNum(teamB.ballNum + scoreB);
                teamB.setLostNum(teamB.lostNum + scoreA);
                if(scoreA > scoreB) {
                    teamA.setScore(teamA.score + 3);
                } else if (scoreA < scoreB) {
                    teamB.setScore(teamB.score + 3);
                } else {
                    //平局
                    teamA.setScore(teamA.score + 1);
                    teamB.setScore(teamB.score + 1);
                }
            }
            //排名
            Collections.sort(list, new Comparator<Team>() {
                @Override
                public int compare(Team o1, Team o2) {
                    if(!o1.score.equals(o2.score)) {
                        return o2.score - o1.score;
                    } else if ((o1.ballNum - o1.lostNum) != (o2.ballNum - o2.lostNum)) {
                        //如果净胜球数不同
                        return (o2.ballNum - o2.lostNum) - (o1.ballNum - o1.lostNum);
                    } else if (!o1.ballNum.equals(o2.ballNum)) {
                        //进球数不同
                        return o2.ballNum - o1.ballNum;
                    } else {
                        return o1.name.compareTo(o2.name);
                    }
                }
            });
            for(Team  team : list) {
                System.out.printf("%s %d %d %d\n",team.name, team.score, team.ballNum, team.lostNum);
            }
            System.out.println("END");
        }

    }


    static class Team {
        String name;
        Integer score;
        Integer ballNum;
        Integer lostNum;

        public Team(String name, Integer score, Integer ballNum, Integer lostNum) {
            this.name = name;
            this.score = score;
            this.ballNum = ballNum;
            this.lostNum = lostNum;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setScore(Integer score) {
            this.score = score;
        }

        public void setBallNum(Integer ballNum) {
            this.ballNum = ballNum;
        }

        public void setLostNum(Integer lostNum) {
            this.lostNum = lostNum;
        }

        public Team() {
        }

    }
}
