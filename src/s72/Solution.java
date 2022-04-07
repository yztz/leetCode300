package s72;
/* https://leetcode-cn.com/problems/rotate-string/ */
public class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        if (goal.equals(s)) return true;
        int n = goal.length();

        char[] sc = s.toCharArray();
        char[] gc = goal.toCharArray();
        tag:
        for (int gi = n - 1; gi > 0; gi--) {
            for (int i = 0; i < n; i++) {
                if (sc[i] != gc[(gi + i) % n]) continue tag;
            }
            return true;
        }

        return false;
    }

}
