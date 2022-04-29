package s94;
/* https://leetcode-cn.com/problems/construct-quad-tree/ */
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;


    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};


class Solution {

    public Node construct(int[][] grid) {
        int n = grid.length;
        return dfs(grid, 0, 0, n);
    }

    private Node dfs(int[][] grid, int x, int y, int size) {
        if (size == 1) return new Node(grid[x][y] != 0, true);
        int half = size / 2;
        Node topLeft = dfs(grid, x, y, half);
        Node topRight = dfs(grid, x, y + half, half);
        Node bottomLeft = dfs(grid, x + half, y, half);
        Node bottomRight = dfs(grid, x + half, y + half, half);

        int cnt = (topLeft.val?1:0) + (topRight.val?1:0) + (bottomLeft.val?1:0) + (bottomRight.val?1:0);

        if (!topLeft.isLeaf || !topRight.isLeaf || !bottomLeft.isLeaf || !bottomRight.isLeaf || cnt != 4 && cnt != 0) {
            return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
        } else {
            return new Node(cnt == 4, true);
        }
    }
}




