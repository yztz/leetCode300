package s65;
/* https://leetcode-cn.com/problems/self-dividing-numbers/ */
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        tag:
        for (int i = left; i <= right; i++) {
            String num = String.valueOf(i);
            for (char c : num.toCharArray()) {
                if (c == '0' || i % (c - '0') != 0) continue tag;
            }
            ans.add(i);
        }
        return ans;
    }
}
