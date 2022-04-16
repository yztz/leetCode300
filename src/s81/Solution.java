package s81;
/* https://leetcode-cn.com/problems/largest-palindrome-product/ */
public class Solution {
    private static final int MOD = 1337;
    public int largestPalindrome(int n) {
        if (n == 1) return 9;
        int upper = (int) Math.pow(10, n) - 1;
        int ans = 0;
        for (int left = upper; left > 0 && ans == 0; left--) {
            long num = left;
            for (int x = left; x > 0; x /= 10) {
                num = num * 10 + x % 10;
            }
            for (long x = upper; x * x > num; x--) {
                if (num % x == 0) {
                    ans =(int) (num % MOD);
                    break;
                }
            }
        }
        return ans;
    }
}
