import java.util.*;
public class LPF {
    static long num = 600851475143L;
    static ArrayList<Long> primes = new ArrayList<>();
    static long maxFactor = 3;
    // geenreate larger prime factors and then build up from there and winl
    public static void main(String args[]) {
        primes.add(2L);

        for (long i = 3; i < Math.sqrt(num); i+= 2L) {
            // check if it is prime (we arent sieving or erasthophanes)
            boolean isPrime = true;
            for (long prime : primes) {
                if (i % prime == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                primes.add(i);
                if (num % i == 0) {
                    maxFactor = i;
                }
            }
        }

        System.out.println(maxFactor);
    }
}
