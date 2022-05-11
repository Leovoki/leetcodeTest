package IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest01 {
    public static void main(String[] args) {
        //创建字节流
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("K:/work/test.txt");
            int readData = fis.read();
            System.out.println(readData);

            readData = fis.read();
            System.out.println(readData);

            readData = fis.read();
            System.out.println(readData);

            readData = fis.read();
            System.out.println(readData);

            readData = fis.read();
            System.out.println(readData);

            readData = fis.read();
            System.out.println(readData);
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
