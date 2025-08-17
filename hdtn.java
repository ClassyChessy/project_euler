public class hdtn {
    public static int numDivisors(int n) {
        int numDivisors = 0;

        for (int i = 1; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                numDivisors  += 2;
            }
        }

        int isqrt = (int)Math.sqrt(n);
        if (isqrt * isqrt == n) {
            numDivisors ++;
        }

        return numDivisors;
    }

    public static void main(String[] args) {
        int i = 1;
        int nd = 1;
        int triangleNumber = 1;
        while (nd < 500) {
            i ++;
            triangleNumber += i;
            nd = numDivisors(triangleNumber);
        }
        System.out.println(triangleNumber);
    }
}
