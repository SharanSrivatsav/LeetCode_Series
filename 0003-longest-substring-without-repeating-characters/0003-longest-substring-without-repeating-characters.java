class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ind [] = new int [256]; for(int i =0;i<256;i++) ind [i] =-1;
        int max =0;
        int l =0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            // sliding window when condition fails we drastically reduce the window size()
            if(ind[c]!=-1&&ind[c]>=l){
                l= ind[c]+1;
            }
            max = Math.max(max,i-l+1);
            ind[c]=i;
        }
        return max;
    }
}