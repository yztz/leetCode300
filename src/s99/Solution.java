package s99;
/* https://leetcode-cn.com/problems/find-the-winner-of-the-circular-game/ */
public class Solution {
    public int findTheWinner(int n, int k) {
        return f(n, k) + 1;
    }

    public int f(int n, int k) {
        if (n == 1) return 0;
        return  (f(n - 1, k) + k) % n;
    }
}
