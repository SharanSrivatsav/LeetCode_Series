class Solution {
    public int maximumTastiness(int[] price, int k) {
        int n = price.length;
        Arrays.sort(price);
        int st =0;
        int en = price[n-1];
        int ans = 0;
        while(st<=en){
            int m = st+(en-st)/2;
            if(isPos(price,m,k)){
                ans=m;
                st=m+1;
            }
            else{
                en=m-1;
            }
        }
        return ans;
    }
    public boolean isPos(int arr[], int m , int k){
        int c =1;
        int last=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]-last>=m){
                c++;
                last=arr[i];
            }
        }
        return c>=k;
    }
}