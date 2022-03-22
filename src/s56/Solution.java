package s56;

import java.util.Arrays;

public class Solution {
    public boolean winnerOfGame(String colors) {
        int[] cnt = new int[2];
        char pre = colors.charAt(0);
        int count = 1;
        for (int i = 1; i < colors.length(); i++) {
            char c = colors.charAt(i);
            if (c == pre) {
                if (count == 2) {
                    System.out.println(i);
                    cnt[c - 'A']++;
                } else {
                    count++;
                }
            } else {
                pre = c;
                count = 1;
            }
        }
        System.out.println(Arrays.toString(cnt));
        return cnt[0] > cnt[1];
    }
}
