class Solution {
    public int slidingPuzzle(int[][] board) {
        String res = "123450";
        StringBuilder val =  new StringBuilder();
        int count =0;
        // a level order BFS to find the solution
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                val.append(board[i][j]);
            }
        }
        // we got the string form of our thing ready
        Set<String> vis = new HashSet<>();
        Queue<String> bq =  new LinkedList<>();
        bq.add(val.toString());
        vis.add(val.toString());
        while(!bq.isEmpty()){
            int en = bq.size();
            for(int i=0;i<en;i++){
                String temp = bq.poll();
                if(res.equals(temp)){
                    return count;
                }
                int ind = temp.indexOf("0");
                // all possible neighbours
                if(ind+1<6&&ind!=2){
                    StringBuilder cop = new StringBuilder(temp);
                    char t = cop.charAt(ind+1);
                    cop.setCharAt(ind+1,'0');
                    cop.setCharAt(ind,t);
                    if(!vis.contains(cop.toString())){
                        bq.add(cop.toString());
                        vis.add(cop.toString());
                    }
                }
                if(ind-1>=0&&ind!=3){
                    StringBuilder cop = new StringBuilder(temp);
                    char t = cop.charAt(ind-1);
                    cop.setCharAt(ind-1,'0');
                    cop.setCharAt(ind,t);
                    if(!vis.contains(cop.toString())){
                        bq.add(cop.toString());
                        vis.add(cop.toString());
                    }
                }
                if(ind+3<6){
                    StringBuilder cop = new StringBuilder(temp);
                    char t = cop.charAt(ind+3);
                    cop.setCharAt(ind+3,'0');
                    cop.setCharAt(ind,t);
                    if(!vis.contains(cop.toString())){
                        bq.add(cop.toString());
                        vis.add(cop.toString());
                    }
                }
                if(ind-3>=0){
                    StringBuilder cop = new StringBuilder(temp);
                    char t = cop.charAt(ind-3);
                    cop.setCharAt(ind-3,'0');
                    cop.setCharAt(ind,t);
                    if(!vis.contains(cop.toString())){
                        bq.add(cop.toString());
                        vis.add(cop.toString());
                    }
                }
            }
            count++;
        }
        return -1;
    }
}