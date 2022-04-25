package s90;
/* https://leetcode-cn.com/problems/random-pick-index/ */
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Solution {
    Map<Integer, BitSet> map = new HashMap<>();
    Random random = new Random();
    int n;
    public Solution(int[] nums) {
        int n = nums.length;
        this.n = n;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            map.putIfAbsent(num, new BitSet(n));
            map.get(num).set(i);
        }

    }

    public int pick(int target) {
        BitSet set = map.get(target);
        int nth = random.nextInt(set.cardinality());
        int ret = set.nextSetBit(0);
        while (nth-- > 0) ret = set.nextSetBit(ret + 1);
        return ret;
    }



}

