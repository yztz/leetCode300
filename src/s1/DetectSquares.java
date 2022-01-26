/* https://leetcode-cn.com/problems/detect-squares/ */
package s1;

public class DetectSquares {
    int[][] map = new int[1001][1001];

    public DetectSquares() {
    }

    public void add(int[] point) {
        int x = point[0], y = point[1];
        map[x][y]++;
    }

    public int count(int[] point) {
        int x = point[0], y = point[1];
        int answer = 0;
        for (int px = 0; px <= 1000; px++) {
            if (map[px][y] == 0 || px == x) continue;
            int deltaX = px - x;
            if (y + deltaX <= 1000 && y + deltaX >= 0) answer += map[x][y + deltaX] * map[px][y + deltaX] * map[px][y];
            if (y - deltaX >= 0 && y - deltaX <= 1000) answer += map[x][y - deltaX] * map[px][y - deltaX] * map[px][y];
        }
        return answer;
    }

}
