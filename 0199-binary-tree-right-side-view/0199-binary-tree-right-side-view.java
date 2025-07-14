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
    public List<Integer> rightSideView(TreeNode root) {
        Deque <TreeNode> dq = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        dq.add(root);
        while(!dq.isEmpty()){
            int size = dq.size();
            res.add(dq.peekLast().val);
            for(int i=0;i<size;i++){
                TreeNode temp = dq.pollFirst();
                if(temp.left!=null){
                    dq.add(temp.left);
                }
                if(temp.right!=null){
                    dq.add(temp.right);
                }
            }
        }
        return res;
    }
}