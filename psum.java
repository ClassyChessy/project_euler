public class psum {
    // primes below 2 mil - sieve time;
    static int sz = 2000000;
    static boolean[] sieve = new boolean[sz];

    public static void main(String[] args) {
        for (int i = 2; i < sz; i++) {
            // see sieve;
            if (sieve[i] == false) {
                for (int j = 2*i; j < sz; j+= i) {
                    sieve[j] = true;
                }
            }
        }

        long sum = 0;
        for (int i = 2; i < sz; i++) {
            if (!sieve[i]) {
                sum += (long)i;
            }
        }
        System.out.println(sum);
    }
    
}
