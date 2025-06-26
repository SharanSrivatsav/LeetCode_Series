/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int st =0;
        int en = n;
        int ans =0;
        while(st<=en){
            int m =st+(en-st)/2;
            if(isBadVersion(m)){
                ans =m;
                en=m-1;
            }
            else{
                st=m+1;
            }
        }
        return ans;
    }
}