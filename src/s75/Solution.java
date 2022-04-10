package s75;
/*https://leetcode-cn.com/problems/unique-morse-code-words/*/
import java.util.HashSet;
import java.util.Set;

public class Solution {
    static final String[] mos = {".-","-...","-.-.","-..",".","..-.","--.",
            "....","..",".---","-.-",".-..","--",
            "-.","---",".--.","--.-",".-.","...","-","..-",
            "...-",".--","-..-","-.--","--.."};
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (char c : word.toCharArray()) {
                sb.append(mos[c - 'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}
