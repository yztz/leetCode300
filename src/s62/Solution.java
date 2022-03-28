package s62;
/* https://leetcode-cn.com/problems/binary-number-with-alternating-bits/solution/jiao-ti-wei-er-jin-zhi-shu-by-leetcode-s-bmxd/ */
public class Solution {
    public boolean hasAlternatingBits(int n) {
        int a = n ^ (n >> 1);
        return (a & (a + 1)) == 0;
    }
}
