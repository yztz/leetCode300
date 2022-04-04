package s23;
/* https://leetcode-cn.com/problems/knight-probability-in-chessboard/ */

public class Solution {
    static int[][] dirs = {{-2, -1}, {-2, 1}, {2, -1}, {2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}};

    public double knightProbability(int n, int k, int row, int column) {
        double[][][] dp = new double[k + 1][n][n];
        for (int step = 0; step <= k; step++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (step == 0) {
                        dp[step][i][j] = 1;
                    } else {
                        for (int[] dir : dirs) {
                            int ni = i + dir[0], nj = j + dir[1];
                            if (ni >= 0 && ni < n && nj >= 0 && nj < n) {
                                dp[step][i][j] += dp[step - 1][ni][nj] / 8;
                            }
                        }
                    }
                }
            }
        }
        return dp[k][row][column];
    }
}

//import java.util.ArrayDeque;
//import java.util.Queue;

//public class NumArray {
//    int escapeCnt = 0;
//    int stayCnt = 0;
//
//    public double knightProbability(int n, int k, int row, int column) {
//        final int[][] DIRS = new int[][] {{1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};
//        Queue<int[]> queue = new ArrayDeque<>();
//        queue.add(new int[]{row, column, k});
//        while (!queue.isEmpty()) {
//            int[] pos = queue.poll();
//            int r = pos[0], c = pos[1], step = pos[2] - 1;
//            if (step == -1) {
//                stayCnt++;
//                continue;
//            }
//            for (int[] dir : DIRS) {
//                int nr =  r + dir[0], nc = c + dir[1];
//                if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
//                    escapeCnt++;
//                }
//                queue.offer(new int[]{nr, nc, step});
//
//            }
//        }
//        return ((double) stayCnt) / (escapeCnt + stayCnt);
//    }
//}
