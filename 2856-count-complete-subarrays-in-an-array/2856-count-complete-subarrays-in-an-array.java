class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int count = 0;
        int dist = 0;
        int freq [] =  new int [2001];
        for(int i : nums){
            if(freq[i]==0){
                dist++;
            }
            freq[i]++;
        }
        Arrays.fill(freq,0);
        int l =0;
        int winC = 0;
        for(int i=0;i<nums.length;i++){
            int val = nums[i];
            if(freq[val]==0){
                winC++;
            }
            freq[val]++;
            while(winC==dist&&l<=i){
                count+=nums.length-i;
                freq[nums[l]]--;
                if(freq[nums[l]]==0){
                    winC--;
                }
                l++;
            }
        }
        return count;
    }
}