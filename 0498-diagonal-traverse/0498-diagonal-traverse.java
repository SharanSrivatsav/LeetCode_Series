class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int res[] = new int[m * n];
        boolean up = true;
        int i = 0;
        int j = 0;
        int p = 0;
        while (p < res.length) {
            if (up) {
                while (i >= 0 && j < n) {
                    res[p++] = mat[i][j];
                    i--;
                    j++;
                }
                if(j==n){
                    i+=2;
                    j--;
                }
                else{
                    i++;
                }
                up=!up;
            }
            else{
                while(i<m&&j>=0){
                    res[p++]=mat[i][j];
                    i++;
                    j--;
                }
                if(i==m){
                    j+=2;
                    i--;
                }
                else{
                    j++;
                }
                up =!up;
            }
        }
        return res;
    }
}