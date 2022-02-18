package s24;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int findCenter(int[][] edges) {
        return edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1] ? edges[0][0] : edges[0][1];
    }

//    public int findCenter(int[][] edges) {
//        Map<Integer, Integer> degrees = new HashMap<>();
//        for (int[] edge : edges) {
//            int u = edge[0], v = edge[1];
//            int uc = degrees.getOrDefault(u, 0) + 1;
//            int vc = degrees.getOrDefault(v, 0) + 1;
//            if (uc >= 2) return u;
//            if (vc >= 2) return v;
//            degrees.put(u, uc);
//            degrees.put(v, vc);
//        }
//        return -1;
//    }
}
