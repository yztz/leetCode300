package s37;
/* https://leetcode-cn.com/problems/add-digits/ */
public class Solution {
//    public int addDigits(int num) {
//        if (num < 10) return num;
//        int ans = 0;
//        char[] chs = String.valueOf(num).toCharArray();
//        for (char c : chs) ans+=c-'0';
//        return addDigits(ans);
//    }
    public int addDigits(int num) {
        if (num == 0) return num;
        return (num - 1) % 9 + 1;
    }
}
