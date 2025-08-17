public class lp {
    static int n = 21;
    static long[][] dp = new long[n][n];

    private static boolean exists(int i, int j) {
        return i >= 0 && j >= 0 && i < n && j < n;
    }
    public static void main(String[] args) {
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[0][0] = 1L;
                }
                else {
                    dp[i][j] = (exists(i-1, j) ? dp[i-1][j] : 0L) + (exists(i, j-1) ? dp[i][j-1] : 0L);
                }
            }
        }
        System.out.println(dp[n-1][n-1]);
    }
}
