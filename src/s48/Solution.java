package s48;
/* https://leetcode-cn.com/problems/minimum-index-sum-of-two-lists/ */
import java.util.*;

public class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        int minIdx = 2000;
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < list2.length; i++) {
            String word = list2[i];
            if (!map.containsKey(word)) continue;
            int sum = map.get(word) + i;
            if (sum == minIdx) {
                ans.add(word);
            } else if (sum < minIdx) {
                minIdx = sum;
                ans.clear();
                ans.add(word);
            }
        }

        return ans.toArray(new String[0]);
    }
}
