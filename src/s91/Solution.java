package s91;
/* https://leetcode-cn.com/problems/projection-area-of-3d-shapes/ */
public class Solution {
    public int projectionArea(int[][] grid) {
        int ans = 0;
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            int cntX = 0, cntY = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    ans++;
                }
                cntX = Math.max(cntX, grid[i][j]);
                cntY = Math.max(cntY, grid[j][i]);
            }
            ans += cntX;
            ans += cntY;

        }
        return ans;
    }
}
