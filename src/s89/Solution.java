package s89;
/* https://leetcode-cn.com/problems/binary-gap/ */
public class Solution {

    public int binaryGap(int n) {
        int pre = -1;
        int i = n;
        int pos = 0;
        int ans = 0;
        while (i > 0) {
            if((i % 2) == 1) {
                if(pre >= 0) ans = Math.max(ans, pos - pre);
                pre = pos;
            }
            i /= 2;
            pos++;
        }

        return ans;
    }
}
