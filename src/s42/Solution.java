package s42;
/* https://leetcode-cn.com/problems/plates-between-candles/ */
public class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        int[] preSum = new int[n];
        for (int i = 0, sum = 0; i < n; i++) {
            if (s.charAt(i) == '*') {
                sum++;
            }
            preSum[i] = sum;
        }
        int[] left = new int[n];
        for (int i = 0, l = -1; i < n; i++) {
            if (s.charAt(i) == '|') {
                l = i;
            }
            left[i] = l;
        }
        int[] right = new int[n];
        for (int i = n - 1, r = -1; i >= 0; i--) {
            if (s.charAt(i) == '|') {
                r = i;
            }
            right[i] = r;
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int x = right[query[0]], y = left[query[1]];
            ans[i] = x == -1 || y == -1 || x >= y ? 0 : preSum[y] - preSum[x];
        }
        return ans;
    }
//    public int[] platesBetweenCandles(String s, int[][] queries) {
//        int n = queries.length;
//        int[] ans = new int[n];
//        int[] states = new int[n]; // -1 start 0 cnt
//        Arrays.fill(states, -1);
//        Map<Integer, List<Integer>> cp = new HashMap<>();
//        for (int i = 0; i < n; i++) {
//            int start = queries[i][0];
//            cp.putIfAbsent(start, new ArrayList<>());
//            cp.get(start).add(i);
//        }
//        List<Integer> proc = new LinkedList<>();
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (cp.containsKey(i)) {
//                proc.addAll(cp.get(i));
//            }
//            Iterator<Integer> iter = proc.iterator();
//            while (iter.hasNext()) {
//                int idx = iter.next();
//                if (c == '|') {
//                    if (states[idx] >= 0) {
//                        ans[idx] += states[idx];
//                    }
//                    states[idx] = 0;
//                } else { // '*'
//                    if (states[idx] >= 0) states[idx]++;
//                }
//                if (queries[idx][1] == i) iter.remove();
//            }
//        }
//
//        return ans;
//    }
}
