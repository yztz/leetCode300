package s92;
/* https://leetcode-cn.com/problems/pacific-atlantic-water-flow/ */
import java.util.*;

public class Solution {
    private static final int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(heights, pacific, i, 0);
        }
        for (int j = 1; j < n; j++) {
            dfs(heights, pacific, 0, j);
        }
        for (int i = 0; i < m; i++) {
            dfs(heights, atlantic, i, n - 1);
        }
        for (int j = 0; j < n - 1; j++) {
            dfs(heights, atlantic, m - 1, j);
        }


        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    ans.add(list);
                }
            }
        }
        return ans;
    }

    void dfs(int[][] height, boolean[][] ocean, int x, int y) {
        if (ocean[x][y])
            return;
        int m = height.length, n = height[0].length;

        ocean[x][y] = true;

        for (int[] dir : DIRS) {
            int nx = x + dir[0], ny = y + dir[1];
            if (nx >= 0 && ny >= 0 && nx < m && ny < n && height[nx][ny] >= height[x][y]) {
                dfs(height, ocean, nx, ny);
            }
        }
    }
}
