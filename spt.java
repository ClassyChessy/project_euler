import java.util.*;
public class spt {
    // search for a and b < sqrt 1000;
    static ArrayList<Integer> squares = new ArrayList<>();
    static int val = 1000;
    static int ans = Integer.MIN_VALUE;
    public static void main(String[] args) {
        // genreate all squares < 100l
        for (int a = 1; a < 999; a++) {
            for (int b = 1; b < 999; b++) {
                int c = (int)Math.sqrt(a * a + b * b);
                if (c * c == a * a + b * b) {
                    if (a + b + c == val) {
                        ans = a*b*c;
                        System.out.println(ans);
                        return;
                    }
                }
            }
        } 
    }
}
