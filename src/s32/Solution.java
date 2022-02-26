package s32;
/* https://leetcode-cn.com/problems/maximum-difference-between-increasing-elements/ */
public class Solution {
    public int maximumDifference(int[] nums) {
        int ans = -1, preMin = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > preMin) {
                ans = Math.max(ans, nums[i] - preMin);
            } else {
                preMin = nums[i];
            }
        }
        return ans;
    }
}
