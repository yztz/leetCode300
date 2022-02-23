package s29;


public class Solution {
    public String reverseOnlyLetters(String s) {
        char[] chs = s.toCharArray();
        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (i < j && !Character.isLetter(chs[i])) i++;
            while (i < j && !Character.isLetter(chs[j])) j--;
            if (i < j) {
                char tmp = chs[j];
                chs[j] = chs[i];
                chs[i] = tmp;
                i++;j--;
            }
        }

        return new String(chs);
    }
}
