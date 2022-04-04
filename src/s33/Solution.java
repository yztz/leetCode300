package s33;
/* https://leetcode-cn.com/problems/optimal-division/ */
public class Solution {
    public String optimalDivision(int[] nums) {
        if (nums.length == 1) return nums[0] + "";
        if (nums.length == 2) return nums[0] + "/" + nums[1];
        StringBuilder sb = new StringBuilder();
        sb.append(nums[0]).append("/(");
        for (int i = 1; i < nums.length; i++) {
            if (i == 1) {
                sb.append(nums[1]);
            } else {
                sb.append("/").append(nums[i]);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}

// 动态规划版本
//class NumArray {
//    public String optimalDivision(int[] nums) {
//        int n = nums.length;
//        Node[][] dp = new Node[n][n];
//        for (int i = 0; i < n; i++) {
//            for (int j = i; j < n; j++) {
//                dp[i][j] = new Node();
//            }
//        }
//
//        for (int i = 0; i < n; i++) {
//            dp[i][i].minVal = nums[i];
//            dp[i][i].maxVal = nums[i];
//            dp[i][i].minStr = String.valueOf(nums[i]);
//            dp[i][i].maxStr = String.valueOf(nums[i]);
//        }
//        for (int i = 1; i < n; i++) {
//            for (int j = 0; j + i < n; j++) {
//                for (int k = j; k < j + i; k++) {
//                    if (dp[j][j + i].maxVal < dp[j][k].maxVal / dp[k + 1][j + i].minVal) {
//                        dp[j][j + i].maxVal = dp[j][k].maxVal / dp[k + 1][j + i].minVal;
//                        if (k + 1 == j + i) {
//                            dp[j][j + i].maxStr = dp[j][k].maxStr + "/" + dp[k + 1][j + i].minStr;
//                        } else {
//                            dp[j][j + i].maxStr = dp[j][k].maxStr + "/(" + dp[k + 1][j + i].minStr + ")";
//                        }
//                    }
//                    if (dp[j][j + i].minVal > dp[j][k].minVal / dp[k + 1][j + i].maxVal) {
//                        dp[j][j + i].minVal = dp[j][k].minVal / dp[k + 1][j + i].maxVal;
//                        if (k + 1 == j + i) {
//                            dp[j][j + i].minStr = dp[j][k].minStr + "/" + dp[k + 1][j + i].maxStr;
//                        } else {
//                            dp[j][j + i].minStr = dp[j][k].minStr + "/(" + dp[k + 1][j + i].maxStr + ")";
//                        }
//                    }
//                }
//            }
//        }
//        return dp[0][n - 1].maxStr;
//    }
//}
//
//class Node {
//    double maxVal, minVal;
//    String minStr, maxStr;
//
//    public Node() {
//        this.minVal = 10000.0;
//        this.maxVal = 0.0;
//    }
//}