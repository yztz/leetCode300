package s63;
<<<<<<< HEAD
/* https://leetcode-cn.com/problems/maximize-the-confusion-of-an-exam/ */
public class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int n = answerKey.length();
        int i1 = 0, j1 = 0;
        int TCnt = 0, FCnt = 0;
        int maxT = 0;
        while (j1 < n) { // T
            char c = answerKey.charAt(j1);
            FCnt += c == 'F' ? 1 : 0;
            while (FCnt > k) {
                c = answerKey.charAt(i1++);
                FCnt -= c == 'F' ? 1 : 0;
            }
            maxT = Math.max(j1 - i1 + 1, maxT);
            j1++;
        }
        int i2 = 0, j2 = 0, maxF = 0;
        while (j2 < n) { // F
            char c = answerKey.charAt(j2);
            TCnt += c == 'T' ? 1 : 0;
            while (TCnt > k) {
                c = answerKey.charAt(i2++);
                TCnt -= c == 'T' ? 1 : 0;
            }
            maxF = Math.max(j2 - i2 + 1, maxF);
            j2++;
        }

        return Math.max(maxT, maxF);
=======
/* https://leetcode-cn.com/problems/find-servers-that-handled-most-number-of-requests/ */
import java.util.*;

public class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        PriorityQueue<int[]> busy = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        PriorityQueue<Integer> available = new PriorityQueue<>();
        int n = arrival.length;
        int[] req = new int[k];
        for (int i = 0; i < k; i++) available.offer(i);
        for (int i = 0; i < n; i++) {
            int time = arrival[i];
            int occupation = load[i];
            while (!busy.isEmpty() && busy.peek()[1] <= time) {
                int[] s = busy.poll();
                available.offer(i + ((s[0] - i) % k + k) % k);
            }
            if (available.isEmpty()) continue;
            int server = available.poll() % k;
            req[server]++;
            busy.offer(new int[]{server, time + occupation});
        }
        int max = Arrays.stream(req).max().getAsInt();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (req[i] == max) ans.add(i);
        }
        return ans;
>>>>>>> origin/master
    }
}
