package s70;
/* https://leetcode-cn.com/problems/prime-number-of-set-bits-in-binary-representation/ */
public class Solution {
//    static final int[] PRIME = {
//            2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31
//    };
    static final boolean[] PRIME = new boolean[32];
    static{
        PRIME[2] = true;
        PRIME[3] = true;
        PRIME[5] = true;
        PRIME[7] = true;
        PRIME[11] = true;
        PRIME[13] = true;
        PRIME[17] = true;
        PRIME[19] = true;
        PRIME[23] = true;
        PRIME[29] = true;
        PRIME[31] = true;
    }

    public int countPrimeSetBits(int left, int right) {
        int ans = 0;
        for (int i = left; i <= right; i++) {
            if (PRIME[Integer.bitCount(i)]) ans++;
        }
        return ans;
    }
}
