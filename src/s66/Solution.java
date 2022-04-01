package s66;
/* https://leetcode-cn.com/problems/array-of-doubled-pairs/ */
import java.util.*;

public class Solution {
    public boolean canReorderDoubled(int[] arr) {
        Integer[] nums = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(nums, (a, b)->{
            if (Math.abs(a) == Math.abs(b)) return a - b;
            return Math.abs(a) - Math.abs(b);
        });
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        for (int num : nums) {
            int n = map.get(num);
            if (n == 0) continue;
            map.put(num, n - 1);
            int m = map.getOrDefault(num * 2, 0);
            if (m == 0) return false;
            map.put(num * 2, m - 1);
        }
        return true;
    }
}
