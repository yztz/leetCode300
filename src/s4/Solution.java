package s4;
/* https://leetcode-cn.com/problems/map-of-highest-peak/ */
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length, n = isWater[0].length;
        int[][] answers = new int[m][n];
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    answers[i][j] = 0;
                } else {
                    answers[i][j] = -1;
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            int h = answers[p[0]][p[1]] + 1;
            for (int[] dir : DIRS) {
                int x = p[0] + dir[0], y = p[1] + dir[1];
                if (x < m && x >= 0 && y < n && y >= 0 && answers[x][y] == -1) {
                    answers[x][y] = h;
                    queue.offer(new int[]{x, y});
                }
            }
        }
        return answers;
    }
}
