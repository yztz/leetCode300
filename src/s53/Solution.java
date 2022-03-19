package s53;


public class Solution {
    StringBuilder sb = new StringBuilder();
    public String tree2str(TreeNode root) {
        dfs(root);
        return sb.toString();
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        sb.append(root.val);
        if (root.left == null && root.right == null) return;
        sb.append("(");
        dfs(root.left);
        sb.append(")");
        sb.append("(");
        dfs(root.right);
        int n = sb.length();
        if (sb.charAt(n - 1) == '(') {
            sb.setLength(n - 1);
        } else {
            sb.append(")");
        }
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
