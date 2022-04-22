package s87;

/* https://leetcode-cn.com/problems/rotate-function/ */
public class Solution {
    //TLE
//    public int maxRotateFunction(int[] nums) {
//        int ans = Integer.MIN_VALUE;
//        for (int i = 0; i < nums.length; i++) {
//            int cnt = 0;
//            for (int j = 0; j < nums.length; j++) {
//                cnt += ((i + j) % nums.length) * nums[j];
//            }
//            ans = Math.max(ans, cnt);
//        }
//        return ans;
//    }

    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int cnt = 0, pre;
        int last = 0;
        for (int i = n - 1; i >= 0; i--) {
            cnt += i * nums[i];
            last += nums[i];
        }
        int ans = cnt;
        for (int i = 1; i <= n; i++) {
            cnt -= nums[n - i] * (n - 1);
            cnt += last - nums[n - i];
            ans = Math.max(ans, cnt);
        }

        return ans;
    }
}
