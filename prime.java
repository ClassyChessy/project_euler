import java.util.*;

public class prime {
    static ArrayList<Integer> primes = new ArrayList<>();
    public static void main(String args[]) {
        primes.add(2);
        int i = 3;
        while (primes.size() < 10001) {
            // check if it is prime (we arent sieving or erasthophanes)
            boolean isPrime = true;
            for (int prime : primes) {
                if (i % prime == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                primes.add(i);
                if (primes.size() == 10001) {
                    break;
                }
            }

            i += 2;
        }

        System.out.println(primes.get(10000));
    }
}
