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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        solver(res,0,root,targetSum,temp);
        return res;
    }
    public static void solver(List<List<Integer>> res ,int sum , TreeNode node,int tar,List<Integer> temp){
        if(node==null){
            return;
        }
        sum+=node.val;
        temp.add(node.val);
        if(sum==tar&&node.left==null&&node.right==null){
            res.add(new ArrayList<>(temp));
        }
        solver(res,sum,node.left,tar,temp);
        solver(res,sum,node.right,tar,temp);
        temp.remove(temp.size()-1);
    }
}