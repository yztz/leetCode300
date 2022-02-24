package s30;
/* https://leetcode-cn.com/problems/where-will-the-ball-fall/ */
public class Solution {
    public int[] findBall(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] loc = new int[n];
        for (int i = 0; i < n; i++) loc[i] = i;
        for (int[] gaps : grid) {
            for (int j = 0; j < n; j++) {
                int pos = loc[j];
                if (pos == -1) continue;
                if (gaps[pos] == 1) {
                    if (pos != n - 1 && gaps[pos + 1] != -1) {
                        loc[j]++;
                    } else {
                        loc[j] = -1;
                    }
                } else {
                    if (pos != 0 && gaps[pos - 1] != 1) {
                        loc[j]--;
                    } else {
                        loc[j] = -1;
                    }
                }
            }
        }

        return loc;
    }
}
