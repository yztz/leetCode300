package s2;

public class Solution {

    public int countValidWords(String sentence) {
        int pos = 0;
        int answer = 0;
        int n = sentence.length();
        while (pos < sentence.length()) {
            while (pos < n && sentence.charAt(pos) == ' ') pos++;
            if (n == pos) return answer;
            int end = pos;
            while (end < n && sentence.charAt(end) != ' ') end++;
            if (isValid(sentence.substring(pos, end))) answer++;
            pos = end;
        }
        return answer;
    }

    public boolean isValid(String word) {
        int n = word.length();
        boolean flag = false;
        boolean gap = false;
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            if ((c == ',' || c == '.' || c == '!') && i < n - 1) return false;
            else if (c >= '0' && c <= '9') return false;
            else if (c == '-') {
                if (gap || !flag) return false;
                flag = false;
                gap = true;
            } else if (c >= 'a' && c <= 'z') flag = true;
        }
        return !gap || flag;
    }

}
