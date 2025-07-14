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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> lq = new LinkedList<>();
        lq.add(root);
        boolean forw = true;
        while (!lq.isEmpty()) {
            int level = lq.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < level; i++) {
                TreeNode t = lq.poll();
                if (forw) {
                    temp.add(t.val);
                } else {
                    temp.add(0, t.val);
                }
                if (t.left != null) {
                    lq.add(t.left);
                }
                if (t.right != null) {
                    lq.add(t.right);
                }
            }
            forw=!forw;
            res.add(temp);
        }
        return res;
    }
}