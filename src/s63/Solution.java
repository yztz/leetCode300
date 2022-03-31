package s63;

/* https://leetcode-cn.com/problems/maximize-the-confusion-of-an-exam/ */
public class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int n = answerKey.length();
        int i1 = 0, j1 = 0;
        int TCnt = 0, FCnt = 0;
        int maxT = 0;
        while (j1 < n) { // T
            char c = answerKey.charAt(j1);
            FCnt += c == 'F' ? 1 : 0;
            while (FCnt > k) {
                c = answerKey.charAt(i1++);
                FCnt -= c == 'F' ? 1 : 0;
            }
            maxT = Math.max(j1 - i1 + 1, maxT);
            j1++;
        }
        int i2 = 0, j2 = 0, maxF = 0;
        while (j2 < n) { // F
            char c = answerKey.charAt(j2);
            TCnt += c == 'T' ? 1 : 0;
            while (TCnt > k) {
                c = answerKey.charAt(i2++);
                TCnt -= c == 'T' ? 1 : 0;
            }
            maxF = Math.max(j2 - i2 + 1, maxF);
            j2++;
        }

        return Math.max(maxT, maxF);
    }

}
