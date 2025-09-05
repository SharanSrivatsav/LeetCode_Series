class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses,(a,b)->a[1]-b[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) ->b-a);
        int time =0;
        for( int c []: courses){
            int dur = c[0];
            int deadLine = c[1];
            time+=dur;
            pq.add(dur);
            if(time>deadLine){
                time-=pq.poll();
            }
        }
        return pq.size();
    }
}