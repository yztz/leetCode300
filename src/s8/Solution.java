package s8;

public class Solution {
    public String reversePrefix(String word, char ch) {
        int pos = word.indexOf(ch);
        if (pos == -1) return word;
        StringBuilder sb = new StringBuilder();
        for (int i = pos; i >= 0; i--) {
            sb.append(word.charAt(i));
        }
        sb.append(word.substring(pos + 1));
        return sb.toString();
    }
}
