package MiHaYou.THREE;

import java.util.Scanner;

public class Main {
    public static boolean fanTan;
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        while(n-- > 0) {
            fanTan = false;
            YingJie werErYa = new YingJie(cin.nextInt(), cin.nextInt(), cin.nextInt(), cin.nextInt());
            YingJie qianJie = new YingJie(cin.nextInt(), cin.nextInt(), cin.nextInt(), cin.nextInt());
            int round = 1;//回合数
            while(werErYa.hp > 0 && qianJie.hp > 0) {
                if(round % 3 == 0) {
                    //主动技阶段
                    if(qianJie.speed >= werErYa.speed) {
                        qianRoundWithPositive(qianJie, werErYa, true);
                        //结算
                        if(overCheck(werErYa, qianJie)) {
                            break;
                        }
                        //维尔呀行动
                        werErYaRoundWithPositive(qianJie, werErYa, true);
                        if(overCheck(werErYa, qianJie)) {
                            break;
                        }
                    } else {
                        //维尔呀先行动
                        werErYaRoundWithPositive(qianJie, werErYa, true);
                        if(overCheck(werErYa, qianJie)) {
                            break;
                        }
                        qianRoundWithPositive(qianJie, werErYa, true);
                    }
                } else {
                    //不是主动技能阶段
                    if(qianJie.speed >= werErYa.speed) {
                        //千劫先
                        qianRoundWithPositive(qianJie, werErYa, false);
                        if(overCheck(qianJie, werErYa)) {
                            break;
                        }
                        werErYaRoundWithPositive(qianJie, werErYa, false);
                        if(overCheck(qianJie, werErYa)) {
                            break;
                        }
                    } else {
                        //维尔塔先
                        werErYaRoundWithPositive(qianJie, werErYa, false);
                        if(overCheck(qianJie, werErYa)) {
                            break;
                        }
                        qianRoundWithPositive(qianJie, werErYa, false);
                        if(overCheck(qianJie, werErYa)) {
                            break;
                        }
                    }
                }
                round++;
            }
            //若跳出循环，说明有人死了，看看是谁
            //overCheck(qianJie, werErYa);

        }
    }
    public static void werErYaRoundWithPositive(YingJie qianJie, YingJie werErYa, boolean positive) {
        //试试被动技能
        isWer(werErYa, qianJie);
        qianJie.hp = werErYa.attack - qianJie.defence > 0 ?  qianJie.hp - (werErYa.attack - qianJie.defence) : qianJie.hp;
        if(positive) {
            fanTan = true;
        }
    }

    public static void qianRoundWithPositive(YingJie qianJie, YingJie werErYa, boolean positive) {
        if(qianJie.hp < 11 || !positive) {
            //改为普通攻击
            if(fanTan) {
                qianJie.hp = qianJieAttack(qianJie) - qianJie.defence > 0 ? qianJie.hp - qianJieAttack(qianJie) - qianJie.defence : 0;
                fanTan = false;
            } else {
                //不反弹
                werErYa.hp = qianJieAttack(qianJie) - werErYa.defence > 0 ? werErYa.hp - qianJieAttack(qianJie) + werErYa.defence : werErYa.hp;
            }
        } else {
            //能够发动主动技
            if(positive && qianJie.hp > 10) {
                //千劫主动技
                werErYa.hp = 45 - werErYa.defence > 0 ? werErYa.hp - (45 - werErYa.defence) - 20 : werErYa.hp - 20;
            }
        }
    }

    public static int positiveWerErYa(YingJie wer) {
        fanTan = true;
        return wer.attack;
    }

    public static int positiveQianjie(YingJie qian) {
        if(qian.hp > 10) {
            qian.hp = qian.hp - 10;

            return 45 + 20;
        } else {
            return qian.attack;
        }
    }

    public static void isWer(YingJie wer, YingJie qian) {
        if(wer.hp < 31 && wer.falg) {
            wer.attack += 15;
            wer.hp += 20;
            qian.hp +=20;
            wer.falg = false;
            return;
        }
        return;
    }

    public static int qianJieAttack(YingJie qian) {
        int cost = qian.initHp - qian.hp;
        return qian.attack + (cost/5);
    }

    public static boolean overCheck(YingJie qian, YingJie wer) {
        if(wer.hp <= 0) {
            System.out.println("Kalpas yame te!");
            return true;
        } else if (qian.hp <= 0) {
            System.out.println("I love V2V forever!");
            return true;
        }
        return false;
    }




}




class YingJie {
    boolean falg = true;
    int initHp;
    int hp;
    int attack;
    int defence;
    int speed;

    public YingJie(int hp, int attack, int defence, int speed) {
        this.hp = hp;
        this.attack = attack;
        this.defence = defence;
        this.speed = speed;
        this.initHp = hp;
    }

}

