class Solution {
    public int kthSmallest(int[][] mat, int k) {
        int st = mat[0][0];
        int en = mat[mat.length-1][mat[0].length-1];
        int ans =0;
        while(st<=en){
            int m = st+(en-st)/2;
            if(count(mat,m)<k){
                st=m+1;
            }
            else{
                ans=m;
                en=m-1;
            }
        }
        return ans;
    }
    public int count(int mat[][], int t){
        int r = mat.length-1;
        int c = mat[0].length-1;
        int ans =0;
        for(int i=r;i>=0;i--){
            if(mat[i][c]<=t){
                ans+=c+1;
            }
            else{
                for(int j=0;j<=c;j++){
                    if(mat[i][j]<=t){
                        ans++;
                    }
                    else{
                        break;
                    }
                }
            }
        }
        return ans;
    }
}