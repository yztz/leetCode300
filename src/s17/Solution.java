package s17;

import java.util.Arrays;

public class Solution {
    public int minimumDifference(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        for (int i = 0, j = k - 1; j < n; i++, j++) {
            ans = Math.min(ans, nums[j] - nums[i]);
        }
        return ans;
    }
}
