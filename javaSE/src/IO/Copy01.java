package IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 使用input+output实现文件拷贝
 */
public class Copy01 {
    public static void main(String[] args) {
        FileInputStream fis = null;        FileOutputStream fos = null;

        try {
            //创建一个输入流读取到内存中
            fis = new FileInputStream("K:\\LeoYu\\document\\瑞慈体检报告-郁毅明.pdf");
            //创建一个输出流到电脑硬盘上
            fos = new FileOutputStream("K:\\转移成功.pdf");

            //最核心的，一边读，一边写
            byte[] bytes = new byte[10*1024];//10kb
            int readCount = 0;
            while((readCount = fis.read(bytes)) != -1) {
                fos.write(bytes,0,readCount);
            }

            //刷新，最后的全部输出
            fos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //分开try catch为了不影响另一个流的关闭
            if(fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
