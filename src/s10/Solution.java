package s10;
/* https://leetcode-cn.com/problems/number-of-rectangles-that-can-form-the-largest-square/ */
public class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        int cnt = 0;
        int maxLen = 0;
        for (int[] rectangle : rectangles) {
            int a = Math.min(rectangle[0], rectangle[1]);
            if (a > maxLen) {
                maxLen = a;
                cnt = 1;
            } else if (a == maxLen) {
                cnt++;
            }
        }
        return cnt;
    }
}
