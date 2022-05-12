package IO;

import jdk.nashorn.internal.runtime.regexp.joni.constants.MetaChar;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * 掌握
 *一次读取b.length个字节
 * 数据存在byte数组里
 * 注意如果下一次读取的时候，新的数据只是覆盖上一次的数据，因此如果数据个数不满的话，会发生脏数据
 * IDEA默认的当前文件路径是project的根
 */
public class FileInputStreamTest03 {
    private Integer a = 0;
    public static void main(String[] args) {

        FileInputStream fis = null;
        try {
            fis = new FileInputStream("javaSE/src/IO/tempfile");

           //用byte数组读，一次读取多个字节。
            int readNum = 0; //方法返回的是读取到几个字节
            byte[] bytes = new byte[4];
            while((readNum = fis.read(bytes)) != -1) {
                if(readNum == -1) {
                    break;
                }
                System.out.print(new String(bytes,0,readNum));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
