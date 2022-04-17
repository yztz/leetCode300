package s82;
/* https://leetcode-cn.com/problems/most-common-word/ */
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (char ch : paragraph.toCharArray()) {
            if (!Character.isAlphabetic(ch)) {
                if (sb.length() > 0) {
                    String word = sb.toString().toLowerCase();
                    map.put(word, map.getOrDefault(word, 0) + 1);
                    sb.setLength(0);
                }
                continue;
            }
            sb.append(ch);
        }
        if (sb.length() > 0) {
            String word = sb.toString().toLowerCase();
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (String ban : banned) map.remove(ban);
        int max = 0;
        String ans = "";
        for (String word : map.keySet()) {
            int cnt = map.get(word);
            if (cnt > max) {
                ans = word;
                max = cnt;
            }
        }
        return ans;
    }
}
