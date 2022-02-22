package s28;

public class Solution {
    static final int[] PRIMES = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
    static final int MOD = (int)1e9 + 7;
    public int numberOfGoodSubsets(int[] nums) {
        int[] cnt = new int[31];
        int stateNum = 1 << 10;
        long[] f = new long[stateNum];
        f[0] = 1;
        for (int num : nums) cnt[num]++;
        for (int i = 2; i <= 30; i++) {
            if (cnt[i] == 0) continue;

            int curState = 0, x = i;
            boolean accept = true;
            for (int j = 0; j < 10; j++) {
                int prime = PRIMES[j];
                int c = 0;
                while (x % prime == 0) {
                    x /= prime;
                    curState |= (1 << j);
                    c++;
                }
                if (c > 1) {
                    accept = false;
                    break;
                }
            }
            if (!accept) continue;
//          for (int j = stateNum - 1; j >= 0; j--)
            for (int j = 0; j < stateNum; j++) {
                if ((j & curState) != 0) continue;
                f[j | curState] = (f[j | curState] + f[j] * cnt[i]) % MOD;
            }
        }
        long ans = 0;
        for (int i = 1; i < stateNum; i++) ans = (ans + f[i]) % MOD;
        for (int i = 0; i < cnt[1]; i++) ans = ans * 2 % MOD;
        return (int) ans;
    }

}





