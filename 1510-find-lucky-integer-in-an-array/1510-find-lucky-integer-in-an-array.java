class Solution {
    public int findLucky(int[] arr) {
        int freq []= new int [501];
        int ans = -1;
        for(int i=0;i<arr.length;i++){
             freq[arr[i]]++;
        }
        for(int i=1;i<freq.length;i++){
            if(i==freq[i]){
                ans=i;
            }
        }
        return ans;
    }
}