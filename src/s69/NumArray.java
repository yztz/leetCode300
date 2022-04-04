package s69;
/* https://leetcode-cn.com/problems/range-sum-query-mutable/ */
public class NumArray {
    int n;
    int[] tree;

    public NumArray(int[] nums) {
        n = nums.length;
        this.tree = new int[n * 4];
        make(0, 0, n - 1, nums);
    }

    void make(int root, int s, int e, int[] nums) {
        if (s == e) {
            tree[root] = nums[s];
            return;
        }
        int m = (s + e) / 2;
        int left = 2 * root + 1, right = 2 * root + 2;
        make(left, s, m, nums);
        make(right, m + 1, e, nums);
        tree[root] = tree[left] + tree[right];
    }

    void update_val(int root, int idx, int s, int e, int val) {
        if (s == e) {
            this.tree[root] = val;
            return;
        }
        int m = (s + e) / 2;
        if (idx <= m) {
            update_val(root * 2 + 1, idx, s, m, val);
        } else {
            update_val(root * 2 + 2, idx, m + 1, e, val);
        }
        tree[root] = tree[root * 2 + 1] + tree[root * 2 + 2];
    }

    public void update(int index, int val) {
        update_val(0, index, 0, n - 1, val);
    }

    int range(int root, int s, int e, int left, int right) {
        if (left == s && right == e) return tree[root];
        int m = (s + e) / 2;
        if (left > m) {
            return range(root * 2 + 2, m + 1, e, left, right);
        } else if (right <= m) {
            return range(root * 2 + 1, s, m, left, right);
        } else {
            return range(root * 2 + 1, s, m, left, m) + range(root * 2 + 2, m + 1, e, m + 1, right);
        }
    }

    public int sumRange(int left, int right) {
        return range(0, 0, n - 1, left, right);
    }
}
