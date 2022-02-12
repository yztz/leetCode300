package s19;

import java.util.Arrays;

public class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] cnt = new int[5];
        for (char c : text.toCharArray()) {
            switch (c) {
                case 'b': cnt[0]++;break;
                case 'a': cnt[1]++;break;
                case 'l': cnt[2]++;break;
                case 'o': cnt[3]++;break;
                case 'n': cnt[4]++;break;
            }
        }
        cnt[2] /= 2;
        cnt[3] /= 2;
        return Arrays.stream(cnt).min().getAsInt();
    }
}
