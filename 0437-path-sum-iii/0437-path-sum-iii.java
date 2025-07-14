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
    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long,Integer> map = new HashMap<>();
        map.put((long)0,1);
        solver(root,targetSum,0,map);
        return count;
    }
    public void solver(TreeNode node, int tar , long sum, HashMap<Long,Integer> map){
        if(node==null){
            return;
        }
        sum+=node.val;
        if(map.containsKey(sum-tar)){
            count+=map.get(sum-tar);
        }
        map.put(sum,map.getOrDefault(sum,0)+1);
        solver(node.left,tar,sum,map);
        solver(node.right,tar,sum,map);
        map.put(sum,map.get(sum)-1);
        if(map.get(sum)==0){
            map.remove(sum);
        }
    }
}