package s86;
/* https://leetcode-cn.com/problems/goat-latin/ */
public class Solution {
    public String toGoatLatin(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            switch (word.charAt(0)) {
                case 'a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U' -> ans.append(word);
                default -> ans.append(word, 1, word.length()).append(word.charAt(0));
            }
            ans.append("ma");
            ans.append("a".repeat(i + 1));
            ans.append(" ");
        }
        ans.setLength(ans.length() - 1);
        return ans.toString();
    }
}
