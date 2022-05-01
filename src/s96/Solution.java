package s96;
/* https://leetcode-cn.com/problems/all-elements-in-two-binary-search-trees/submissions/ */

import java.util.ArrayList;
import java.util.List;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
}

public class Solution {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        inorder(root1, l1);
        inorder(root2, l2);
        int i = 0, j = 0;
        List<Integer> ans = new ArrayList<>();
        while (i < l1.size() && j < l2.size()) {
            int a = l1.get(i), b = l2.get(j);
            if (a < b) {
                ans.add(a);
                i++;
            } else if (a > b) {
                ans.add(b);
                j++;
            } else {
                ans.add(a);
                ans.add(a);
                i++;j++;
            }
        }
        while (i < l1.size()) ans.add(l1.get(i++));
        while (j < l2.size()) ans.add(l2.get(j++));
        return ans;
    }

    private void inorder(TreeNode root, List<Integer> ans) {
        if (root == null) return;
        inorder(root.left, ans);
        ans.add(root.val);
        inorder(root.right, ans);
    }
}





