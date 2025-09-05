class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int st=0;
        int en=citations.length-1;
        int ans = 0;
        while(st<=en){
            int m = st+(en-st)/2;
            int val = citations[m];
            if(citations.length-m>val){
                st=m+1;
            }
            else{
                ans=citations.length-m;
                en=m-1;
            }
        }
        return ans;
    }
}