package s31;

public class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        int r1, r2, r3, v1, v2, v3;

        int gap = num1.indexOf('+');
        r1 = Integer.parseInt(num1.substring(0, gap));
        v1 = Integer.parseInt(num1.substring(gap + 1, num1.length() - 1));
        gap = num2.indexOf('+');
        r2 = Integer.parseInt(num2.substring(0, gap));
        v2 = Integer.parseInt(num2.substring(gap + 1, num2.length() - 1));
        r3 = r1 * r2 - v1 * v2;
        v3 = r1 * v2 + r2 * v1;

        return String.format("%d+%di", r3, v3);
    }
}
