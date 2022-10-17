import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Decode {
    public static void main(String[] args) {
        String data = "QzlDMEY3NDE5QTI0NjIyMTkwMDA5RDI4NEZBNDNCNjUxNDdCMkE4NA==";
        byte[] bytes = Base64.getDecoder().decode(data);
        System.out.println(new String(bytes));

    }
}
