package s49;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    int maxOr = 0;
    int cnt = 0;
    int[] nums;

    public int countMaxOrSubsets(int[] nums) {
        this.nums = nums;
        dfs(0, nums.length - 1);
        return this.cnt;
    }

    private void dfs(int prev, int idx) {
        if (idx == -1) {
            if (prev > maxOr) {
                maxOr = prev;
                cnt = 1;
            } else if (prev == maxOr) {
                cnt++;
            }
            return;
        }

        dfs(prev | nums[idx], idx - 1);
        dfs(prev, idx - 1);
    }
}







