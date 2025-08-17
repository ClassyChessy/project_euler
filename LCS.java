public class LCS {
    static int sz = 1000000;
    static boolean[] chainStarts = new boolean[sz+1];
    
    private static int chainLength(long n, int cnt) {
        // call stack may get to big so iterative - screw it lets try it first at least;
        if (n == 1L) return cnt;
        if (n < sz) chainStarts[(int)n] = true;
        if (n % 2L == 1L) {
            return chainLength(3*n + 1L, cnt+1);
        } else {
            return chainLength(n / 2, cnt + 1);
        }
    }


    public static void main(String[] args) {
        int maxLength = 1;
        int num = 0;
        chainStarts[1] = true;
        for (int i = 1; i < chainStarts.length; i++) {
            if (!chainStarts[i]) {
                int len = chainLength((long)i, 1);
                if (len > maxLength) {
                    num = i;
                    maxLength = len;
                }
            }
        }
        System.out.println(num);
    }
}
