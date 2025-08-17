import java.util.*;

public class smallest_multiple {
    // break it up into its prime factors;
    static int res = 1;
    static public ArrayList<Integer> primes = new ArrayList<>();


// 2
// 3
// 2
// 5
// 7
// 2
// 3
// 11
// 13
// 2
// 17


    public static void main(String[] args) {
        // we will now find the sum or res and do shit;
        // the set of all prime factors must be tehre;
        primes.add(2);
        primes.add(3);
        primes.add(5);
        primes.add(7);
        primes.add(11);
        primes.add(13);
        primes.add(17);
        primes.add(19);

        HashSet<Integer> uniquePrimes = new HashSet<>();
        for (int i = 2; i <= 20; i++) {
            ArrayList<Integer> pfs = primeFactors(i);
            for (int pf : pfs) {
                uniquePrimes.add(pf);
            }
        }

        for (int val : uniquePrimes) {
            res *= val;
        }
        System.out.println(res);
    } 

    public static ArrayList<Integer> primeFactors(int x) {
        ArrayList<Integer> pfs = new ArrayList<>();

        for (int prime : primes) {
            if (x % prime == 0) {
                pfs.add(prime);
            }
        }
        return pfs;
    }


}
