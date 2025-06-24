class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> ans = new ArrayList<>();
        int i=0;
        boolean ind [] = new boolean[nums.length];
        while(i<nums.length){
            if(nums[i]==key){
              for(int j=i-k;j<=i+k&&j<nums.length;j++){
                if(j>=0&&!ind[j]){
                  ans.add(j);
                  ind[j]=true;
                }
              }
            }
            i++;
        } 
      return ans;
    }
}