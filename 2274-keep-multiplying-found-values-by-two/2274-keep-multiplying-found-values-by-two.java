class Solution {
    public int findFinalValue(int[] nums, int original) {
        int freq [] = new int [2001];
        int c = 0;
        for(int i:nums){
            freq[i]++;
        }
        while(freq[original]>0){
            original*=2;
        }
        return original;
    }
}