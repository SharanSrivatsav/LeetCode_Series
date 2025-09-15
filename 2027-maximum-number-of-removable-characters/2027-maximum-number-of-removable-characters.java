class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
        int freq [] =  new int [26];
        int st = 0;
        int ans = 0;
        int en = removable.length;
        while(st<=en){
            int m = st+(en-st)/2;
            if(isPos(s,removable,p,m)){
                ans=m;
                st=m+1;
            }
            else{
                en=m-1;
            }
        }
        return ans;
    }
    public boolean isPos(String s , int rem [] ,String p,int val){
        // for rem
        boolean vis[]= new boolean [s.length()];
        for(int i=0;i<val;i++){
            vis[rem[i]]=true;
        }
        int j = 0;
        for(int i=0;i<s.length();i++){
            if(vis[i]){
                continue;
            }
            if(s.charAt(i)==p.charAt(j)){
                j++;
            }
            if(j==p.length()){
                return true;
            }
        }
        return false;
    }
}