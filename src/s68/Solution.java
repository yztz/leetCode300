package s68;
/* https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target/ */
public class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int i = 0, j = letters.length - 1;
        if (letters[j] <= target) return letters[0];
        while (i < j) {
            int mid = (j - i) / 2 + i;
            if (letters[mid] <= target) i = mid + 1;
            else j = mid;
        }
        return letters[i];
    }
}
