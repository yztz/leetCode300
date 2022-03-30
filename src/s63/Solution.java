package s63;
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
    }
}
