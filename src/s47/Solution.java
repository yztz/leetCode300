package s47;
/* https://leetcode-cn.com/problems/utf-8-validation/ */
public class Solution {
    public boolean validUtf8(int[] data) {
        int n = data.length;
        for (int i = 0; i < n; i++) {
            int num = 0;
            byte a = (byte) data[i];
            if (a >= 0) num = 1;
            else while (a < 0) {
                a <<= 1;
                if (num == 1 && a >= 0) return false;
                num++;
            }
            if (num > n - i || num > 4) return false;
            for (int j = i + 1; j < i + num; j++)
                if ((data[j] & 0b1100_0000) != 0b1000_0000) return false;
            i += num - 1;
        }

        return true;
    }
}
