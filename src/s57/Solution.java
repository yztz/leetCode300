package s57;
/* https://leetcode-cn.com/problems/k-th-smallest-in-lexicographical-order/ */
public class Solution {
    public int findKthNumber(int n, int k) {
        int prefix = 1;
        while (k > 1) {
            int c = getCnt(prefix, n);
//            System.out.printf("prefix = %d cnt = %d\n", prefix, c);
            if (k <= c) { // 大于则遍历子树
                prefix *= 10;
                k--;
            } else {    // 小于向后遍历
                k-=c;
                prefix++;
            }
        }
        return prefix;
    }
    private int getCnt(int x, int limit) {
        String a = String.valueOf(x), b = String.valueOf(limit);
        int n = a.length(), m = b.length(), k = m - n;
        int ans = 0, u = Integer.parseInt(b.substring(0, n));
        for (int i = 0; i < k; i++) ans += Math.pow(10, i);
        if (u > x) ans += Math.pow(10, k);
        else if (u == x) ans += limit - x * Math.pow(10, k) + 1;
        return ans;
    }
}
