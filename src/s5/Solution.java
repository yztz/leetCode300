package s5;
/* https://leetcode-cn.com/problems/uncommon-words-from-two-sentences/ */
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        Set<String> re = new HashSet<>();

        for (String word : s1.split(" ")) {
            if (!set1.add(word)) re.add(word);
        }
        for (String word : s2.split(" ")) {
            if (!set2.add(word)) re.add(word);
        }

        Set<String> answers = new HashSet<>(set1);
        set1.retainAll(set2);
        answers.removeAll(set1);
        set2.removeAll(set1);
        answers.addAll(set2);
        answers.removeAll(re);
        return answers.toArray(new String[0]);
    }
}
