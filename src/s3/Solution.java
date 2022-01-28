package s3;
/* https://leetcode-cn.com/problems/the-number-of-weak-characters-in-the-game/ */
import java.util.Arrays;

public class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (a, b)-> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        int answer = 0;
        int maxDefense = 0;
        for (int[] property : properties) {
            if (property[1] < maxDefense) {
                answer++;
            } else {
                maxDefense = property[1];
            }
        }
        return answer;
    }
}
