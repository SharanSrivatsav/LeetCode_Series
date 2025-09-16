class Solution {
    public int maximumScore(int a, int b, int c) {
        PriorityQueue<Integer> pq =  new PriorityQueue(Collections.reverseOrder());
        pq.add(a);pq.add(b);pq.add(c);
        int count = 0;
        int z =0;
        while(!pq.isEmpty()){
            while(pq.contains(0)){
                pq.remove(0);
            }
            if(!pq.isEmpty()){
                int val = pq.poll();
                if(val==1){
                    z++;
                }
                if(z==2){
                    return count+1;
                }
                if(pq.size()>0){
                    int val2 = pq.poll();
                    if(val2==1){
                        z++;
                    }
                    if(z>=2){
                        return count+1;
                    }
                    pq.offer(val-1);
                    pq.offer(val2-1);
                    count++;
                }
                else{
                    count+=val;
                }
            }
        }
        return count;
    }
}