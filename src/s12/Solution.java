package s12;
/* https://leetcode-cn.com/problems/sum-of-unique-elements/ */
public class Solution {
    public int sumOfUnique(int[] nums) {
        int[] cnt = new int[101];
        int ans = 0;
        for (int num : nums) {
            switch (cnt[num]) {
                case 0: ans+=num;break;
                case 1: ans-=num;break;
            }
            cnt[num]++;
        }
        return ans;
    }
}
