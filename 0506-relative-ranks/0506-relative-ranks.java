class Surr{
    int val;
    int ind;
    Surr(int v , int w){
        val = v;
        ind = w;
    }
}
class Solution {
    public String[] findRelativeRanks(int[] score) {
        String [] ans = new String [score.length];
        PriorityQueue <Surr> pq = new PriorityQueue <>((a,b) -> b.val - a.val);
        for(int i=0;i<score.length;i++){
            Surr x = new Surr(score[i],i);
            pq.add(x);
        }
        int c =0;
        while(!pq.isEmpty()){
            Surr x = pq.poll();
            int i = x.ind;
            c++;
            if(c==1){
                ans[i]="Gold Medal";
            }
            else if(c==2){
                ans[i]="Silver Medal";
            }
            else if (c==3){
                ans[i]="Bronze Medal";
            }
            else{
                ans[i]=String.valueOf(c);
            } 
        }
        return ans;
    }
}