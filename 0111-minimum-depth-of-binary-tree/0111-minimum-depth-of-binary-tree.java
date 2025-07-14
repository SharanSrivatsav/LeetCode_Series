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
    public int minDepth(TreeNode root) {
        return depthFinder(root);
    }
    public int depthFinder(TreeNode root){
        if(root==null){
            return 0;
        }
        if(root.left==null){
            return 1+depthFinder(root.right);
        }
        if(root.right==null){
            return 1+depthFinder(root.left);
        }
        int l = depthFinder(root.left);
        int r = depthFinder(root.right);
        return 1+Math.min(l,r);
    }
}