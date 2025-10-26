class Solution {
    public int convertTime(String curr, String corr) {
        String arr1 [] = curr.split(":");
        String arr2 [] =  corr.split(":");
        int changes = 0;
        int a  = Integer.parseInt(arr1[0]);
        int b  = Integer.parseInt(arr2[0]);
        int  c = 60*(b-a);
        a  = Integer.parseInt(arr1[1]);
        b  = Integer.parseInt(arr2[1]);
        if(a>b){
            c-=(a-b);
        }
        else{
            c+=b-a;
        }
        changes+=c/60;
        c=c%60;
        changes+=c/15;
        c=c%15;
        changes+=c/5;
        c%=5;
        changes+=c/1;
        c%=1;
        return changes;
    }
}