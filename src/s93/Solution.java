package s93;
/* https://leetcode-cn.com/problems/sort-array-by-parity/ */
public class Solution {

    public int[] sortArrayByParity(int[] nums) {
        // 两次遍历
//        int n = nums.length;
//        int[] ans = new int[n];
//        int pos = 0;
//        for (int i = 0; i < n; i++) {
//            if (nums[i] % 2 == 1) ans[pos++] = nums[i];
//        }
//        for (int i = 0; i < n; i++) {
//            if (nums[i] % 2 == 0) ans[pos++] = nums[i];
//        }
//        return ans;
        int n = nums.length;
        int i = 0, j = n - 1;
        int[] ans = new int[n];
        for (int num : nums) {
            if (num % 2 == 0) {
                ans[i++] = num;
            } else {
                ans[j--] = num;
            }
        }
        return ans;
    }


}
