package s84;

import java.util.ArrayList;
import java.util.List;

/* https://leetcode-cn.com/problems/shortest-distance-to-a-character/
   ref: https://leetcode-cn.com/problems/heaters/
* */
public class Solution {

    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] ans = new int[n];
        List<Integer> loc = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == c) loc.add(i);
        }
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == c) ans[i] = 0;
            else ans[i] = Math.abs(binarySearch(loc, i) - i);
        }
        return ans;
    }

    private int binarySearch(List<Integer> loc, int t) {
        int i = 0, j = loc.size() - 1;
        int ret = -1;
        int delta = Integer.MAX_VALUE;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            int l = loc.get(mid);
            int d = Math.abs(t - l);
            if (d < delta) {
                delta = d;
                ret = l;
            }
            if (l >= t) j = mid - 1;
            else i = mid + 1;
        }
        return ret;
    }
}








