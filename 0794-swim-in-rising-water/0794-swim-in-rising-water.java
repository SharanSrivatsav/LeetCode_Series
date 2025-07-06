class pair{
    int x ;
    int y ;
    pair(int x , int y){
        this.x=x;
        this.y=y;
    }
}
class Solution {
    public int swimInWater(int[][] grid) {
        int k  = grid.length; int min = Integer.MAX_VALUE;
        int n = grid[0].length; int max = Integer.MIN_VALUE;
        for(int i=0;i<k;i++){
           for(int j=0;j<n;j++){
               min = Math.min(min,grid[i][j]);
               max = Math.max(max,grid[i][j]);
           }
        }
        int st = min ; int en = max ; int ans =-1;
        while(st<=en){
            int mid = st+(en-st)/2;
            if(isPos(grid,mid)){
                ans = mid;
                en= mid-1;
            }
            else{
                st=mid+1;
            }
        }
        return ans;
    }
    static int rd [] ={-1,1,0,0};
    static int cd [] = {0,0,-1,1};
    static boolean v[][];
    public static boolean isPos(int [][]grid,int m){
        int g = grid.length;
        int h = grid[0].length;
        v =  new boolean [g][h];
        Queue <pair> bq = new LinkedList<>();
        if(grid[0][0]>m){
            return false;
        }
        bq.add(new pair(0,0));
        v[0][0]=true;
        while(!bq.isEmpty()){
            pair p = bq.poll();
            int a = p.x;
            int b = p.y;
            if(a==g-1&&b==h-1){
                    return true;
            }
            for(int i=0;i<4;i++){
                int r = a+rd[i];
                int c = b+cd[i];
                if(r<0||c<0||r>=g||c>=h||v[r][c]){
                    continue;
                }
                v[r][c]=true;
                if(grid[r][c]<=m){
                    bq.add( new pair(r,c));
                }
            }
        }
        return false;
    }
}