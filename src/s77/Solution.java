package s77;

public class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int lines = 1;
        int cnt = 0;
        for (char c : s.toCharArray()) {
            int width = widths[c - 'a'];
            if (cnt + width > 100) {
                lines++;
                cnt = width;
            } else {
                cnt +=  width;
            }
        }

        return new int[]{lines, cnt};
    }
}
