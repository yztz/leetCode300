package s85;
/* https://leetcode-cn.com/problems/longest-absolute-file-path/ */
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int lengthLongestPath(String input) {
        int ans = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        Deque<Integer> back = new ArrayDeque<>();
        int i = 0;
        while (i < input.length()) {
            int length = 0;
            char ch;

            while (input.charAt(i) == '\t') {
                int l = back.pop();
                deque.push(l);
                length += l + 1;
                i++;
            }
            int pos = i;
            boolean file = false;
            while (i < input.length() && (ch = input.charAt(i)) != '\n'){
                if (ch == '.') file = true;
                i++;
            }
            if (file) {
                ans = Math.max(ans, length + i - pos);
            } else {
                deque.push(i - pos);
            }
            back.clear();
            while (!deque.isEmpty()) back.push(deque.pop());
        }
        return ans;
    }
}
