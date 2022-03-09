package s43;
/* https://leetcode-cn.com/problems/smallest-rotation-with-highest-score/ */
public class Solution {

    public int bestRotation(int[] nums) {
        int n = nums.length;
        int[] diffs = new int[n];
        for (int i = 0; i < n; i++) {
            int low = (i + 1) % n;
            int high = (i - nums[i] + n + 1) % n;
            diffs[low]++;
            diffs[high]--;
            if (low >= high) {
                diffs[0]++;
            }
        }
        int bestIndex = 0;
        int maxScore = 0;
        int score = 0;
        for (int i = 0; i < n; i++) {
            score += diffs[i];
            if (score > maxScore) {
                bestIndex = i;
                maxScore = score;
            }
        }
        return bestIndex;
    }
}


// 超时 O(n2)
//    public int bestRotation(int[] nums) {
//        int n = nums.length;
//        int score = 0;
//        int k = 0;
//        for (int i = 0; i <= n; i++) {
//            int s = 0;
//            for (int j = 0; j < n; j++) {
//                s += (n + j - i) % n - nums[j] >= 0 ? 1 : 0;
//            }
//            if (s > score) {
//                score = s;
//                k = i;
//            }
//        }
//
//        return k;
//    }

