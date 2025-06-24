class Solution {
    public int maxArea(int[] height) {
        int st = 0;
        int end = height.length-1;
        int max=0;

        while(st<end){
            int width = end-st;
            int minh = Math.min(height[st],height[end]);
            max = Math.max(max,(minh*width));
            if(height[st]<height[end]){
                st++;
                continue;
            }
                end--;
        }
        return max;
    }
}