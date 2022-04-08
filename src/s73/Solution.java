package s73;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
/* https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/ */
public class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        final Node TAG = new Node();
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        queue.offer(TAG);

        List<Integer> line = new ArrayList<>();
        while (!queue.isEmpty()) {
            Node n = queue.poll();
            if (n == TAG) {
                if (!queue.isEmpty()) queue.offer(TAG);
                ans.add(line);
                line = new ArrayList<>();
            } else {
                line.add(n.val);
                queue.addAll(n.children);
            }
        }
        return ans;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
