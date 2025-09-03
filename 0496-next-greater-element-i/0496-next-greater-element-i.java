class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map =  new HashMap<>();
        Stack<Integer> stk = new Stack<>();
        for(int i=0;i<nums2.length;i++){
            if(stk.isEmpty()){
                stk.push(i);
                continue;
            }
            while(!stk.isEmpty()&&nums2[stk.peek()]<nums2[i]){
                map.put(nums2[stk.pop()],nums2[i]);
            }
            stk.add(i);
        }
        for(int i=0;i<nums1.length;i++){
            if(map.containsKey(nums1[i])){
                 nums1[i]=map.get(nums1[i]);
            }
            else{
                nums1[i]=-1;
            }
        }
        return nums1;
    }
}