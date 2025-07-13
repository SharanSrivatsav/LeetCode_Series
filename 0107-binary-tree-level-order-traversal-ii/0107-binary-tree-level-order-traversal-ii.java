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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
         List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> lq = new LinkedList<>();
        lq.add(root);
        while (!lq.isEmpty()) {
            int end = lq.size();
            List<Integer> t = new ArrayList<>();
            for (int i = 0; i < end; i++) {
                TreeNode temp = lq.poll();
                t.add(temp.val);
                if (temp.left != null) {
                    lq.add(temp.left);
                }
                if (temp.right != null) {
                    lq.add(temp.right);
                }
            }
            res.add(0,t);
        }
        return res;
    }
}