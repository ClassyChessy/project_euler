import java.util.*;
public class sum_of_squares {
    // generate all primes < 150
    // find all N

    static ArrayList<Integer> primes = new ArrayList<>();

    private static int S(long N) {
        int sum = 0;
        for (int a = 1; a < Math.sqrt(N/2); a ++) {
            long complement = N - (long)(a * a);
            long sc = (int)Math.sqrt(complement);
            if (sc * sc == complement) {
                sum += a;
            }
        }
        return sum;
    }

    private static void generate_primes_till(int n) {
        if (primes.size() == 0) primes.add(2); 
        for (int i = 3; i <= n; i+=2) {
            boolean isValid = true;
            for (int prime : primes) {
                if (prime > Math.sqrt(n)) break;
                if (i % prime == 0) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                primes.add(i);
            }
        }
    }

    public static void main(String[] args) {
        // generate our 4k+1 primes;
        generate_primes_till(150);
        ArrayList<Integer> four_primes = new ArrayList<>();
        for (int prime : primes) {
            if ((prime-1) % 4 == 0) {
                four_primes.add(prime);
            }
        }

        long total = 0;
        // bitmask this baby! to get all subsets!!!
        int fp_sz = four_primes.size();
        for (int i = 1; i < (1 << fp_sz); i++) {
            long n = 1L;
            for (int j = 0; j < fp_sz; j++) {
                if ((i & (1 << j)) > 0) n *= (long)four_primes.get(j);
            }
            System.out.println(n);
            total += S(n);
        }
        System.out.println(total);
    }

    
}
