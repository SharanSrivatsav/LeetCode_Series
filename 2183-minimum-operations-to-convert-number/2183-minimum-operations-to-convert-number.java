class Solution {
    public int minimumOperations(int[] nums, int start, int goal) {
        if(start==goal){
            return 0;
        }
        int steps = 0;
        Set<Integer> set = new HashSet<>();
        Queue<Integer> bq = new LinkedList<>();
        bq.add(start);
        set.add(start);
        while(!bq.isEmpty()){
            int en = bq.size();
            for(int j=0;j<en;j++){
                int val = bq.poll();
                if(val==goal){
                    return steps;
                }
                for(int i : nums){
                    if((val^i)==goal||val-i==goal||val+i==goal){
                        return steps+1;
                    }
                    if(val-i >= 0 && val-i <= 1000 &&!set.contains(val-i)){
                        set.add(val-i);
                        bq.add(val-i);
                    }
                    if(val+i >= 0 && val+i <= 1000 &&!set.contains(val+i)){
                        set.add(val+i);
                        bq.add(val+i);
                    }
                    if((val^i) >= 0 && (val^i) <= 1000 &&!set.contains(val^i)){
                        set.add(val^i);
                        bq.add(val^i);
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}