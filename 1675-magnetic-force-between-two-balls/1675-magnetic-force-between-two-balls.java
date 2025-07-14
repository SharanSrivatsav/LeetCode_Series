class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int st =1;
        int en = position[position.length-1]-position[0];
        int ans =0;
        while(st<=en){
            int mid = st+(en-st)/2;
            if(isPos(position,mid,m)){
                ans=mid;
                st=mid+1;
            }
            else{
               en=mid-1;
            }
        }
        return ans;
    }
    public static boolean isPos(int arr[], int gap,int balls){
        int c =1;
        int lastpos = arr[0];
        for(int i=1;i<arr.length;i++){
           if(arr[i]-lastpos>=gap){
             lastpos=arr[i];
             c++;
           }
        }
        return c>=balls;
    }
}