class Solution {
    public boolean canMeasureWater(int x, int y, int target) {
      Set<String> set = new HashSet<>();
      return dfs(x,y,0,0,set,target);  
    }
    public static boolean dfs (int xval, int yval, int jug1, int jug2 ,Set<String> set , int t ){
        // there are 6 possibilites at this problem
        // empty jug - 1
        // empty jug - 2
        // fill jug - 1 
        // fill jug - 2 
        // pour from jug - 1
        // pour from jug - 2

        //base cond to tell the possibility
        if(jug1==t||jug2==t||jug1+jug2==t){
            return true;
        }
         
        // base cond to stop stack over flow
        String s = jug1+"|"+jug2;
        if(set.contains(s)){
            return false;
        }
        set.add(s);
        // possibility - 1
        if(dfs(xval,yval,jug1,yval,set,t)){
            return true;
        }
        //possibility - 2
        if(dfs(xval,yval,xval,jug2,set,t)){
            return true;
        }
        // possibility - 3
        if(dfs(xval,yval,0,jug2,set,t)){
            return true;
        }
        // possibility - 4
        if(dfs(xval,yval,jug1,0,set,t)){
            return true;
        }
        // possibility - 5 (pour from jug 1 to jug 2)
        int req = yval-jug2;
        int pass = Math.min(req,jug1);
        jug1-=pass;
        jug2+=pass;
        if(dfs(xval,yval,jug1,jug2,set,t)){
            return true;
        }
        // possibility - 6 (pour from jug 2 to jug 1)
        req = xval-jug1;
        pass = Math.min(jug2,req);
        jug1+=pass;
        jug2-=pass;
        if(dfs(xval,yval,jug1,jug2,set,t)){
            return true;
        }
        return false;
    }
}