package s11;
/* https://leetcode-cn.com/problems/path-with-maximum-gold/ */
public class Solution {
    int m, n;
    int[][] grid;
    final int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int getMaximumGold(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dfs(i, j, 0));
            }
        }
        return ans;
    }

    private int dfs(int i, int j, int cnt) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0 || cnt == 25) return 0;

        int cur = grid[i][j];
        int num = 0;
        grid[i][j] = 0;
        for (int[] dir : DIRS) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            num = Math.max(num, dfs(ni, nj, cnt + 1));
        }
        grid[i][j] = cur;

        return cur + num;
    }

}
