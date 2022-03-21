package s55;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<Integer> list = new ArrayList<>();
    public boolean findTarget(TreeNode root, int k) {
        traverse(root);
        int i = 0, j = list.size() - 1;
        while (i < j) {
            int a = list.get(i), b = list.get(j);
            int sum = a + b;
            if (sum > k) j--;
            else if (sum < k) i++;
            else return true;
        }
        return false;
    }

    public void traverse(TreeNode root) {
        if (root == null) return;
        traverse(root.left);
        list.add(root.val);
        traverse(root.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
