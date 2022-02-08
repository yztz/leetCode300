package s14;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        Map<Integer, Integer> row = new HashMap<Integer, Integer>();
        Map<Integer, Integer> col = new HashMap<Integer, Integer>();
        Map<Integer, Integer> diagonal = new HashMap<Integer, Integer>();
        Map<Integer, Integer> antiDiagonal = new HashMap<Integer, Integer>();
        Set<Long> points = new HashSet<Long>();
        for (int[] lamp : lamps) {
            if (!points.add(hash(lamp[0], lamp[1]))) {
                continue;
            }
            row.put(lamp[0], row.getOrDefault(lamp[0], 0) + 1);
            col.put(lamp[1], col.getOrDefault(lamp[1], 0) + 1);
            diagonal.put(lamp[0] - lamp[1], diagonal.getOrDefault(lamp[0] - lamp[1], 0) + 1);
            antiDiagonal.put(lamp[0] + lamp[1], antiDiagonal.getOrDefault(lamp[0] + lamp[1], 0) + 1);
        }
        int[] ret = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int r = queries[i][0], c = queries[i][1];
            if (row.getOrDefault(r, 0) > 0) {
                ret[i] = 1;
            } else if (col.getOrDefault(c, 0) > 0) {
                ret[i] = 1;
            } else if (diagonal.getOrDefault(r - c, 0) > 0) {
                ret[i] = 1;
            } else if (antiDiagonal.getOrDefault(r + c, 0) > 0) {
                ret[i] = 1;
            }
            for (int x = r - 1; x <= r + 1; x++) {
                for (int y = c - 1; y <= c + 1; y++) {
                    if (x < 0 || y < 0 || x >= n || y >= n) {
                        continue;
                    }
                    if (points.remove(hash(x, y))) {
                        row.put(x, row.get(x) - 1);
                        if (row.get(x) == 0) {
                            row.remove(x);
                        }
                        col.put(y, col.get(y) - 1);
                        if (col.get(y) == 0) {
                            col.remove(y);
                        }
                        diagonal.put(x - y, diagonal.get(x - y) - 1);
                        if (diagonal.get(x - y) == 0) {
                            diagonal.remove(x - y);
                        }
                        antiDiagonal.put(x + y, antiDiagonal.get(x + y) - 1);
                        if (antiDiagonal.get(x + y) == 0) {
                            antiDiagonal.remove(x + y);
                        }
                    }
                }
            }
        }
        return ret;
    }

    public long hash(int x, int y) {
        return (long) x + ((long) y << 32);
    }
}

//import java.util.HashMap;
//import java.util.Map;
//
//public class Solution {
//    int n;
//    Map<Integer, Boolean> lights;
//    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
//        this.n = n;
//        lights = new HashMap<>();
//        for (int[] lamp : lamps) {
//            lights.put(lamp[0] * n + lamp[1], true);
//        }
//        int[] ans = new int[queries.length];
//        for (int i = 0; i < queries.length; i++) {
//            int x = queries[i][0], y = queries[i][1];
//            ans[i] = query(x, y) ? 1 : 0;
//            close(x, y);
//        }
//        return ans;
//    }
//
//    private void close(int x, int y) {
//        final int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
//        for (int[] dir : DIRS) {
//            int nx = x + dir[0], ny = y + dir[1];
//            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
//                lights.put(nx * n + ny, false);
//            }
//        }
//        lights.put(x * n + y, false);
//    }
//
//    private boolean query(int x, int y) {
//        int n = this.n;
//        int n2 = n * n;
//        int idx = x * n + y;
//        for (int i = 0; i < n; i++) {
//            if (lights.getOrDefault(x * n + i, false) || lights.getOrDefault(i * n + y, false)) return true;
//        }
//        for (int i = idx; i >= 0; i -= n + 1) {   // \
//            if (lights.getOrDefault(i, false)) return true;
//            if (i % n == 0) break;
//        }
//        for (int i = idx; i < n2; i += n + 1) {   // \
//            if (lights.getOrDefault(i, false)) return true;
//            if ((i + 1) % n == 0) break;
//        }
//        for (int i = idx; i > 0; i -= n - 1) {   // /
//            if (lights.getOrDefault(i, false)) return true;
//            if ((i + 1) % n == 0) break;
//        }
//        for (int i = idx; i < n2 - 1; i += n - 1) {   // /
//            if (lights.getOrDefault(i, false)) return true;
//            if (i % n == 0) break;
//        }
//        return false;
//    }
//
//
//}
