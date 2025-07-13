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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> lq = new LinkedList<>();
        lq.add(root);
        while (!lq.isEmpty()) {
            int end = lq.size();
            List<Integer> t = new ArrayList<>();
            //bfs template
            for (int i = 0; i < end; i++) {
                TreeNode temp = lq.poll();
                if(temp!=null){
                    t.add(temp.val);
                    if (temp.left != null) {
                       lq.add(temp.left);
                    }
                    if (temp.right != null) {
                       lq.add(temp.right);
                    }
                }
            }
            if(t.size()!=0)
             res.add(t);
        }
        return res;
    }
}