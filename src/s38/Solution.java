package s38;
/* https://leetcode-cn.com/problems/sum-of-subarray-ranges/ */
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        Deque<Integer> maxStack = new ArrayDeque<>();
        Deque<Integer> minStack = new ArrayDeque<>();
        int[] leftMin = new int[n];
        int[] leftMax = new int[n];
        int[] rightMin = new int[n];
        int[] rightMax = new int[n];
        for (int i = 0; i < n; i++) {
            while (!minStack.isEmpty() && nums[minStack.peek()] > nums[i]) {
                minStack.pop();
            }
            leftMin[i] = minStack.isEmpty() ? -1 : minStack.peek();
            minStack.push(i);

            while (!maxStack.isEmpty() && nums[maxStack.peek()] <= nums[i]) {
                maxStack.pop();
            }
            leftMax[i] = maxStack.isEmpty() ? -1 : maxStack.peek();
            maxStack.push(i);
        }
        maxStack.clear();
        minStack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!minStack.isEmpty() && nums[minStack.peek()] >= nums[i]) {
                minStack.pop();
            }
            rightMin[i] = minStack.isEmpty() ? n : minStack.peek();
            minStack.push(i);

            while (!maxStack.isEmpty() && nums[maxStack.peek()] < nums[i]) {
                maxStack.pop();
            }
            rightMax[i] = maxStack.isEmpty() ? n : maxStack.peek();
            maxStack.push(i);
        }
        long sumMax = 0;
        long sumMin = 0;
        for (int i = 0; i < n; i++) {
            sumMin += (long)(i - leftMin[i]) * (rightMin[i] - i) * nums[i];
            sumMax += (long)(i - leftMax[i]) * (rightMax[i] - i) * nums[i];
        }
        return sumMax - sumMin;
    }
}
