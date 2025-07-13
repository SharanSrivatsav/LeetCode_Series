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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> x =  new ArrayList<>();
        inorder(root,x);
        return x;
    }
    public static void inorder(TreeNode node, List<Integer> x){
        if(node==null){
            return;
        }
        inorder(node.left,x);
        x.add(node.val);
        inorder(node.right,x);
    }
}