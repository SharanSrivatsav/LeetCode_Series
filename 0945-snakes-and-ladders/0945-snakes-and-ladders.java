class Solution {
    public int snakesAndLadders(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int arr [] = new int [m*n+1];
        boolean l_to_r = true;
        int p = 1;
        for(int i =m-1;i>=0;i--){
            if(l_to_r){
                for(int j=0;j<n;j++){
                    arr[p++]=board[i][j];
                }
            }
            else{
                 for(int j=n-1;j>=0;j--){
                    arr[p++]=board[i][j];
                }
            }
            l_to_r = !l_to_r;
        }
        // flattened the 2d array into 1 d array
        Queue<Integer>  bq =  new LinkedList<>();
        boolean vis [] = new boolean [m*n+1];
        bq.add(1);
        int steps = 0;
        while(!bq.isEmpty()){
            int s = bq.size();
            steps++;
            for(int i=0;i<s;i++){
                int pos = bq.poll();
                if(pos==m*n){
                    return steps-1;
                }
                for(int j=1;j<=6;j++){
                    if(pos+j>m*n){
                        continue;
                    }
                    int dest = arr[pos+j]==-1 ? pos+j: arr[pos+j];
                    if(!vis[dest]){
                        vis[dest]=true;
                        bq.add(dest);
                    }
                }
            }
        }
        return -1;
    }
}