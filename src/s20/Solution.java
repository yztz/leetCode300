package s20;
/* https://leetcode-cn.com/problems/single-element-in-a-sorted-array/ */
public class Solution {
//    public int singleNonDuplicate(int[] nums) {
//        if (nums.length == 1) return nums[0];
//        int n = nums.length;
//        int i = 0, j = n - 1;
//        while (i <= j) {
//            int mid = (i + j) / 2;
//            boolean flag = (j - i) % 4 == 0;
//            if (mid == 0) {
//                if (nums[mid] != nums[mid + 1]) return nums[mid];
//                i = mid + 2;
//            } else if (mid == n - 1) {
//                if (nums[mid] != nums[mid - 1]) return nums[mid];
//                i = mid - 2;
//            } else {
//                if (nums[mid] == nums[mid - 1]) {
//                    if (flag) j = mid - 2;
//                    else i = mid + 1;
//                } else if (nums[mid] == nums[mid + 1]) {
//                    if (flag) i = mid + 2;
//                    else j = mid - 1;
//                } else {
//                    return nums[mid];
//                }
//            }
//        }
//        return -1;
//    }
    // 自己写复杂了
    public int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            mid -= mid & 1;
            if (nums[mid] == nums[mid + 1]) {
                low = mid + 2;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }

}
