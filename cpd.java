public class cpd {
    static int sz = 10_000_000;
    static int[] numDivisors = new int[sz+1];
    public static void setup() {
        for (int i = 1; i <= sz; i++) {
            for (int j = i; j <= sz; j += i) {
                numDivisors[j] ++;
            }
        }
    }

    public static void main(String[] args) {
        setup();
        int ans = 0;
        for (int i = 2; i < sz; i++) {
            if (numDivisors[i] == numDivisors[i+1]) ans ++;
        }
        System.out.println(ans);
    }
}
