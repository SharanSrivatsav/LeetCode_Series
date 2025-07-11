class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);Arrays.sort(heaters);
        int st = 0;
        int en = Math.max(houses[houses.length-1],heaters[heaters.length-1]);
        int ans = 0;
        while(st<=en){
            int m = st+(en-st)/2;
            if(isValid(houses,heaters,m)){
                ans = m;
                //passing radius and trying to find a small one as answer
                en=m-1;
            }
            else{
                st=m+1;
            }
        }
        return ans;
    }
    public static boolean isValid(int house[], int heater[],int m){
        int p = 0;
        for(int i=0;i<heater.length;i++){
           // range formation
           int left = heater[i]-m;
           int right = heater[i]+m;
           // checking whether the houses are in the range
           while(p<house.length&&house[p]>=left&&house[p]<=right){
            p++;
           }
        }
        return p>=house.length;
    }
}