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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> lq =  new LinkedList<>();
        lq.add(root);
        int ans = 0;
        while(!lq.isEmpty()){
            int size = lq.size();
            ans=lq.peek().val;
            for(int i=0;i<size;i++){
                TreeNode temp = lq.poll();
                if(temp.left!=null){
                    lq.add(temp.left);
                }
                if(temp.right!=null){
                    lq.add(temp.right);
                }
            }
        }
        return ans;
    }
}