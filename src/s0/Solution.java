package s0;

public class Solution {

//    public int numberOfMatches(int n) {
//        if (n < 2) return 0;
//        if (n % 2 == 1) {
//            return n / 2 + numberOfMatches(n / 2 + 1);
//        } else {
//            return n / 2 + numberOfMatches(n / 2);
//        }
//    }

    public int numberOfMatches(int n) {
         return n - 1;
    }
}
