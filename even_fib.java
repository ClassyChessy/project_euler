import java.util.*;
public class even_fib {
    static int sum = 0; 
    static HashMap<Integer, Integer> fibCache = new HashMap<>();
    public static void main(String[] args) {
        int fib_val = 1;
        int cnt = 1;
        while (fib_val <= 4000000) {
            fib_val = fib(cnt);

            cnt ++;
            if (fib_val % 2 == 0) {
                sum += fib_val;
            }
            
        }
        System.out.println(sum);
    }

    public static int fib(int x) {
        if (x < 2) {
            return 1;
        }

        if (fibCache.containsKey(x)) {
            return fibCache.get(x);
        }

        fibCache.put(x, fib(x-1) + fib(x-2));
        return fibCache.get(x);
    }
}
