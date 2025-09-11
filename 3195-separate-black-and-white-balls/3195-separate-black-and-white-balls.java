class Solution {
    public long minimumSteps(String s) {
        int newpos =0;
        long res=0;
        char x [] = s.toCharArray();
        for(int i=0;i<x.length;i++){
            if(x[i]=='0'){
                char t = x[newpos];
                x[newpos]='0';
                x[i]=t;
                res+=i-newpos;
                newpos++;
            }
        }
        return res;
    }
}