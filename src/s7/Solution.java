package s7;
/* https://leetcode-cn.com/problems/longest-nice-substring/ */
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public String longestNiceSubstring(String s) {
        int[] up = new int[26];
        int[] low = new int[26];
        int n = s.length();
        if (n < 2) return "";
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c))
                low[c - 65]++;
            else
                up[c - 97]++;
        }
        List<Integer> gaps = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int c = Character.toLowerCase(s.charAt(i)) - 97;
            if (low[c] == 0 || up[c] == 0) gaps.add(i);
        }
        if (gaps.isEmpty()) {
            return s;
        } else {
//            System.out.println(gaps);
            int maxLen = 0;
            String ans = "";
            int begin = 0;
            for (int i = 0; begin < n && i < gaps.size() + 1; i++) {
                String tmp;
                if (i == gaps.size()) {
                    tmp = longestNiceSubstring(s.substring(begin));
                } else {
                    int end = gaps.get(i);
                    tmp = longestNiceSubstring(s.substring(begin, end));
                    begin = end + 1;
                }
                if (tmp.length() > maxLen) {
                    maxLen = tmp.length();
                    ans = tmp;
                }
            }
            return ans;
        }

    }

}
