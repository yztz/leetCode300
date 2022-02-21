package s27;
/* https://leetcode-cn.com/problems/push-dominoes/ */
class Solution {
    public String pushDominoes(String dominoes) {
        char[] answers = dominoes.toCharArray();
        int i = 0, n = dominoes.length();
        char left = 'L';
        while (i < n) {
            int j = i;
            while (j < n && answers[j] == '.') j++;
            char right = j < n ? answers[j] : 'R';
            // System.out.println(left + " " + right);
            if (left == right) {
                while (i < j) answers[i++] = right;
            } else if (left == 'R' && right == 'L') {
                int k = j - 1;
                while (i < k) {
                    // System.out.println(i + " " + k);
                    answers[i++] = left;
                    answers[k--] = right;
                }
            }
            i = j + 1;
            left = right;
        }

        return String.valueOf(answers);
    }
}
