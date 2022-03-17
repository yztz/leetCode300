package s51;
/* https://leetcode-cn.com/problems/longest-word-in-dictionary/ */
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public String longestWord(String[] words) {
        Set<String> set = new HashSet<>();
        String ans = "";
        set.add("");
        Collections.addAll(set, words);
        Arrays.sort(words);
        for (String word : words) {
            String sub = word.substring(0, word.length() - 1);
            if (!set.contains(sub)) {
                set.remove(word);
            } else if (word.length() > ans.length() || word.length() == ans.length() && word.compareTo(ans) < 0) {
                ans = word;
            }
        }
        return ans;
    }
}
