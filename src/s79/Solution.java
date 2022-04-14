package s79;

public class Solution {
    public int maximumWealth(int[][] accounts) {
        int ans = 0;
        for (int[] account : accounts) {
            int cnt = 0;
            for (int m : account) cnt += m;
            ans = Math.max(cnt, ans);
        }
        return ans;
    }
}
