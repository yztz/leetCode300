package s83;
/* https://leetcode-cn.com/problems/lexicographical-numbers/ */
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        int num = 1;
        for (int i = 0; i < n; i++) {
            if (num > n) {
                while (num + 1 > n || num % 10 == 9) {
                    num /= 10;
                }
                num++;
            }
            ans.add(num);
            num *= 10;
        }

        return ans;
    }
}
