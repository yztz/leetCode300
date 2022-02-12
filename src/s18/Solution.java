package s18;
/* https://leetcode-cn.com/problems/number-of-enclaves/ */
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    public int numEnclaves(int[][] grid) {
        final int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                        grid[i][j] = 2;
                        queue.add(new int[]{i, j});
                    } else {
                        ans++;
                    }
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int x = pos[0], y = pos[1];
            for (int[] dir : DIRS) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx >= 0 && nx < m && ny > 0 && ny < n && grid[nx][ny] == 1) {
                    grid[nx][ny] = 2;
                    ans--;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        return ans;
    }
}
