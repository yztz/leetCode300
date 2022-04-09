package s74;
/* https://leetcode-cn.com/problems/reaching-points/ */
public class Solution {
//    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
//        if (sx == 0 && sy == 0) return false;
//        if (sx == 0 && tx % sy == 0 && ty % sy == 0) return true;
//        if (sy == 0 && tx % sx == 0 && ty % sx == 0) return true;
//        Queue<int[]> queue = new ArrayDeque<>();
//        queue.offer(new int[]{sx, sy});
//        while (!queue.isEmpty()) {
//            int[] pair = queue.poll();
//            int x = pair[0], y = pair[1];
//            if (x > tx || y > ty) continue;
//            if (x == tx && y == ty) return true;
//            queue.offer(new int[]{x + y, y});
//            queue.offer(new int[]{x, x + y});
//        }
//        return false;
//    }


    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (tx > sx && ty > sy && tx != ty) {
            if (tx > ty) {
                tx %= ty;
            } else {
                ty %= tx;
            }
        }
        if (tx == sx && ty == sy) {
            return true;
        } else if (tx == sx) {
            return ty > sy && (ty - sy) % tx == 0;
        } else if (ty == sy) {
            return tx > sx && (tx - sx) % ty == 0;
        } else {
            return false;
        }
    }


//    private boolean dfs(int x, int y, int  tx, int ty) {
//        if (x > tx || y > ty) return false;
//        if (x == tx && y == ty) return true;
//        return dfs(x + y, y, tx, ty) || dfs(x, x + y, tx, ty);
//    }
}
