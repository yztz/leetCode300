package s34;

import java.util.Arrays;

public class Solution {
    public int maximumRequests(int n, int[][] requests) {
        int[] delta = new int[n];
        int ans = 0, m = requests.length;
        for (int mask = 0; mask < (1 << m); ++mask) {
            int cnt = Integer.bitCount(mask);
            if (cnt <= ans) {
                continue;
            }
            Arrays.fill(delta, 0);
            for (int i = 0; i < m; ++i) {
                if ((mask & (1 << i)) != 0) {
                    ++delta[requests[i][0]];
                    --delta[requests[i][1]];
                }
            }
            boolean flag = true;
            for (int x : delta) {
                if (x != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans = cnt;
            }
        }
        return ans;
    }
}



