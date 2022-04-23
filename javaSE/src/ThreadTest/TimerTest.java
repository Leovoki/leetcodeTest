package ThreadTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 使用定时器创建定时任务
 */
public class TimerTest {
    public static void main(String[] args) throws ParseException {
        //创建定时器对象
        Timer timer = new Timer();
        //Timer timer = new Timer(true);//守护线程的形式
        //创建定时任务
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date firstTime = sdf.parse("2022-04-20 16:50:00");
        timer.schedule(new LogTimerTask(), firstTime, 1000*5);
    }
}

//编写一个定时任务类
//假如是记录日志的任务
class LogTimerTask extends TimerTask {

    @Override
    public void run() {
        //任务
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strTime = sdf.format(new Date());
        System.out.println(strTime + "完成一次数据备份！");
    }
}