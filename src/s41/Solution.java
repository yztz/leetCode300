package s41;

public class Solution {

    public String convertToBase7(int num) {
        if (num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        int a = Math.abs(num);
        while (a > 0) {
            sb.insert(0, a % 7);
            a /= 7;
        }
        System.out.println(sb);
        return num >= 0 ? "" : "-" +  sb.reverse().toString();
    }
}
