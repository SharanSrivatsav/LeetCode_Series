class Pair{
    long x;
    long y;
    Pair(long x, long y){
        this.x=x;
        this.y=y;
    }
}
class Solution {
     int mod = 1_000_000_007;
    public int countPaths(int n, int[][] roads) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int a [] : roads){
            adj.get(a[0]).add(new Pair(a[1],a[2]));
            adj.get(a[1]).add(new Pair(a[0],a[2]));
        }
        // graph is created
        long dist [] = new long[n];
        long ways [] = new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        dist[0]=0;
        ways[0]=1;
      Queue<Pair> pq = new PriorityQueue<>(Comparator.comparingLong(pair -> pair.y));
        pq.add(new Pair(0,0));
        while(!pq.isEmpty()){
            Pair t = pq.poll();
            for(Pair i : adj.get((int)t.x)){
                if(t.y+i.y<dist[(int)i.x]){
                    dist[(int)i.x]=(t.y+i.y);
                    ways[(int)i.x]=ways[(int)t.x];
                    pq.add(new Pair(i.x,t.y+i.y));
                }
                else if(t.y+i.y==dist[(int)i.x]){
                    ways[(int)i.x]=(ways[(int)i.x]+ways[(int)t.x])%mod;
                }
            }
        }
       return(int) ways[n-1];
    }
}