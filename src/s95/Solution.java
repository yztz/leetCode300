package s95;

import java.util.Arrays;

public class Solution {
    public int smallestRangeI(int[] nums, int k) {
        int max = Arrays.stream(nums).max().getAsInt();
        int min = Arrays.stream(nums).max().getAsInt();
        return max - min >= 2 * k ? max - min - 2 * k : 0;
    }
}
