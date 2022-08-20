public class C100 {

    public static void main(String[] args) {
        Long sum = 1L;
        for(long i = 1L; i <= 100L; i++) {
            sum = sum * i;
        }
        System.out.println(sum);
    }
}
