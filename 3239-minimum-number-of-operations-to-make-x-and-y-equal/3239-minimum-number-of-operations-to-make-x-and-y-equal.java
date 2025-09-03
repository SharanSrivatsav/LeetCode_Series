class Solution {
    public int minimumOperationsToMakeEqual(int x, int y) {
        Queue<Integer> bq  = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        bq.add(x);
        int opCount =0; 
        while(!bq.isEmpty()){
            int en = bq.size();
            for(int i=0;i<en;i++){
                int val = bq.poll();
                if(set.contains(val)){
                    continue;
                }
                set.add(val);
                if(val==y){
                    return opCount;
                }
                if(val%11==0){
                    bq.add(val/11);
                }
                if(val%5==0){
                    bq.add(val/5);
                }
                bq.add(val-1);
                bq.add(val+1);
            }
            opCount++;
        }
        return opCount;
    }
}