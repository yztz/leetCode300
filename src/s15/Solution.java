package s15;

/* https://leetcode-cn.com/problems/count-number-of-pairs-with-absolute-difference-k/ */

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int countKDifference(int[] nums, int k) {
        int res = 0, n = nums.length;
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        for (int j = 0; j < n; ++j) {
            res += cnt.getOrDefault(nums[j] - k, 0) + cnt.getOrDefault(nums[j] + k, 0);
            cnt.put(nums[j], cnt.getOrDefault(nums[j], 0) + 1);
        }
        return res;
    }
}


//public class NumArray {
//    public int countKDifference(int[] nums, int k) {
//        int n = nums.length;
//        int ans = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j < n; j++) {
//                if (Math.abs(nums[i] - nums[j]) == k) ans++;
//            }
//        }
//        return ans;
//    }
//}
