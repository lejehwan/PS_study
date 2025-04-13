/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    private int MINIMUM = Integer.MAX_VALUE;
    private TreeNode prev;

    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return MINIMUM;
    }

    private void inOrder(TreeNode node) {
        if (node == null) return;

        inOrder(node.left);

        if (prev != null) {
            MINIMUM = Math.min(MINIMUM, Math.abs(prev.val - node.val));
        }
        prev = node;
        inOrder(node.right);
    }
}