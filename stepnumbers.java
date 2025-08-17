public class stepnumbers {
    // use every digit
    // use a bitwise trick to see if every number is 1023 - and keep digits less than 10-> 40; we may memoize, but idrc;
    public static Long[][][] memo = new Long[10][41][1024];

    public static long search(int prevDigit, int numDigits, int panDigits) {
        if (numDigits > 40) {
            return 0L;
        }


        if (memo[prevDigit][numDigits][panDigits] != null) {
            return memo[prevDigit][numDigits][panDigits];
        }

        long total = panDigits == 1023 ? 1L : 0L;
        if (prevDigit == 0) {
            total += search(1, numDigits + 1, (panDigits | (1 << 1)));
        }
        else if (prevDigit == 9) {
            total += search(8, numDigits + 1, (panDigits | (1 << 8)));
        }
        else {
            total += search(prevDigit + 1, numDigits + 1, (panDigits | (1 << (prevDigit + 1)))) + search(prevDigit-1, numDigits + 1, (panDigits | (1 << (prevDigit-1))));
        }
        memo[prevDigit][numDigits][panDigits] = total;
        return memo[prevDigit][numDigits][panDigits];
    }

    public static void main(String[] args) {
        long ans = 0;
        for (int i = 1; i <= 9; i++) {
            ans += search(i, 1, 1 << i);
        }
        System.out.println(ans);
    }
}
