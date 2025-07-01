class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int c =0;
        for(int i : costs){
           if(coins-i<0){
             break;
           }
           coins=coins-i;
           c++;
        }
        return c;
    }
}