class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b)-> (a[0]==b[0])?Integer.compare(a[1],b[1]):Integer.compare(a[0],b[0]));
        int max = points[0][1];
        int c = 1;
        for(int i=1;i<points.length;i++){
            if(max>=points[i][0]){
                max = Math.min(max, points[i][1]); 
            }
            else{
               c++;
               max=points[i][1];
            }
        }
        return c;
    }
}