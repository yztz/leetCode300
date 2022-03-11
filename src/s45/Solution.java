package s45;

import java.util.ArrayList;
import java.util.List;
/* https://leetcode-cn.com/problems/count-nodes-with-the-highest-score/ */
public class Solution {
    List<Integer>[] children;
    int n;
    long maxScore = 0;
    int cnt = 0;

    public int countHighestScoreNodes(int[] parents) {
        n = parents.length;
        children = new List[n];
        for (int i = 0; i < n ; i++) children[i] = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            children[parents[i]].add(i);
        }
        dfs(0);
        return cnt;
    }

    int dfs(int idx) {
        int size = n - 1;
        long score = 1;
        for (int child : children[idx]) {
            int cc = dfs(child);
            score *= cc;
            size -= cc;
        }
        if (idx != 0) score *= size;

        if (score == maxScore) {
            cnt++;
        } else if (score > maxScore) {
            maxScore = score;
            cnt = 1;
        }

        return n - size;
    }
}
