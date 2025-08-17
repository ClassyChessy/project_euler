// just simply run everything
public class multiples_of_3_or_5 {
    static int sum = 0; 
    public static void main(String[] args) {
        for (int i = 3; i < 1000; i+= 3) {
            sum += i;
        }
        for (int i = 5; i < 1000; i += 5) {
            if (i % 3 != 0) {
                sum += i;
            }
        }
        System.out.println(sum);
    }
}
