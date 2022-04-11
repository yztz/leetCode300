package s76;
/* https://leetcode-cn.com/problems/count-numbers-with-unique-digits/ */
public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int ans = 1;

        for (int i = 0; i < n; i++) {
            int t = 9;
            for (int j = 0; j < i; j++) {
                t = t * (9 - j);
            }
            ans += t;
        }
        return ans;
    }
}
