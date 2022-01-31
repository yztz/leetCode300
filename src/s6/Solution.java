package s6;
/* https://leetcode-cn.com/problems/number-of-steps-to-reduce-a-number-to-zero/ */
public class Solution {
    public int numberOfSteps(int num) {
        int ans = 0;
        while (num != 0) {
            if (num % 2 == 1) {
                num -= 1;
            } else {
                num >>= 1;
            }
            ans++;
        }
        return ans;
    }
}
