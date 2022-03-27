package s61;
/* https://leetcode-cn.com/problems/find-missing-observations/ */

public class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int cnt = 0, m = rolls.length;
        for (int roll : rolls) cnt += roll;
        cnt = (n + m) * mean - cnt;
        if (cnt > 6 * n) return new int[0];
        int[] ans = new int[n];
        int av = cnt / n;
        int remainder = cnt % n;
        for (int i = 0; i < n; i++) {
            ans[i] = av;
            if (i < remainder) ans[i]++;
        }
        return ans;
    }
}
