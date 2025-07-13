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
    public int res =0;
    public int diameterOfBinaryTree(TreeNode root) {
       solver(root);
       return res;
    }
    public int solver(TreeNode node){
        if(node == null){
            return 0;
        }
        int l = solver(node.left);
        int r = solver(node.right);
        res =Math.max(l+r,res);
        return 1+Math.max(l,r);
    }
}