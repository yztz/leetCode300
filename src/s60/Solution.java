package s60;
/* https://leetcode-cn.com/problems/baseball-game/ */
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public int calPoints(String[] ops) {
        Deque<Integer> score = new ArrayDeque<>();
        for (String op : ops) {
            switch (op) {
                case "+":
                    int a = score.pop();
                    int b = score.peek();
                    score.push(a);
                    score.push(a + b);
                    break;
                case "D":
                    score.push(score.peek() * 2);
                    break;
                case "C":
                    score.pop();
                    break;
                default:
                    score.push(Integer.parseInt(op));
            }
        }
        int ans = 0;
        for (int num : score) {
            ans += num;
        }
        return ans;
    }
}
