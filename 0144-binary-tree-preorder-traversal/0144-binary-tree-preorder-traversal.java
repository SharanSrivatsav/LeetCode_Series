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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> x =  new ArrayList<>();
        solver(root,x);
        return x;
    }
    public static void solver(TreeNode node , List<Integer> x ){
        if(node==null){
            return;
        }
        x.add(node.val);
        solver(node.left,x);
        solver(node.right,x);
    }
}