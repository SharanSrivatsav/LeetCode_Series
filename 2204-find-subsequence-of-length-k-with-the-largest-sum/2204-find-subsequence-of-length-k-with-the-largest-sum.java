class pair {
    int val;
    int ind;
    pair(int x, int y) {
        val = x;
        ind = y;
    }
}
class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<pair> pq = new PriorityQueue<>((a,b) -> b.val-a.val);
        for(int i=0;i<nums.length;i++){
            pair p = new pair(nums[i],i);
            pq.offer(p);
        }
        pair ans[] = new pair[k];
        for(int i=0;i<k;i++){
            ans[i]=pq.poll();
        }
        Arrays.sort(ans, (a,b) -> a.ind-b.ind);
        int res [] = new int [k];
        for(int i=0;i<k;i++){
            res[i]=ans[i].val;
        }
        return res;
    }
}