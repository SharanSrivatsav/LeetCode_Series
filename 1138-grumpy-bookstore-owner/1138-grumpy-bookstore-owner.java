class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int initial =0; int k =0; int max = 0;
        for(int i:grumpy) {
            initial+=(i==0)?customers[k]:0;
            k++;
        }
        for(int i=0;i<minutes;i++) if(grumpy[i]==1) initial+=customers[i];
        max=initial;
        for(int i = minutes;i<grumpy.length;i++){
             initial-=(grumpy[i-minutes]==1)?customers[i-minutes]:0;
             initial+=(grumpy[i]==1)?customers[i]:0;
             max=Math.max(max,initial);
        } 
        return max;
    }
}