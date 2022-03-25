package s59;

public class Solution {

    public int trailingZeroes(int n) {
        int p = 5;
        int ans = 0;
        while (true) {
            int cnt = n / p;
            if (cnt == 0) break;
            ans += cnt;
            p*=5;
        }
        return ans;
    }
}
