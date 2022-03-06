package s40;
/* https://leetcode-cn.com/problems/find-good-days-to-rob-the-bank/ */
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        List<Integer> ans = new ArrayList<>();
        int n = security.length;
        int[] c = new int[n];
        for (int i = 1; i < n; i++) {
            if (security[i] == security[i - 1]) continue;
            c[i] = security[i] > security[i - 1] ? 1 : -1;
        }
        int[] a = new int[n + 1];   // 增
        int[] b = new int[n + 1];   // 减
        for (int i = 1; i <= n; i++) {
            a[i] = a[i - 1] + (c[i - 1] == 1 ? 1 : 0);
            b[i] = b[i - 1] + (c[i - 1] == -1 ? 1 : 0);
        }
        for (int i = time; i < n - time; i++) {
            if (a[i + 1] - a[i - time + 1] == 0 && b[i + time + 1] - b[i + 1] == 0) ans.add(i);
        }
        return ans;

    }
}
