public class LPP {
    static int res = 0;

    static boolean isPalindrome(int x) {
        String s = Integer.toString(x);
        for (int i = 0; i < s.length()/2; i++) {
            if (s.charAt(i) != s.charAt(s.length()- 1 - i)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        for (int a = 100; a < 1000; a++) {
            for (int b = 100; b < 1000; b++) {
                int prod = a * b;
                res = isPalindrome(prod) ? Math.max(prod, res) : res;
            }
        }
        System.out.println(res);
    }
}

