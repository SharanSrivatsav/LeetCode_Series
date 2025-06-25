class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String,Integer> map = new LinkedHashMap<>();
        for(String s : arr){
            map.put(s,map.getOrDefault(s,0)+1);
        }
        int c =0;
        for(Map.Entry<String,Integer> x : map.entrySet()){
            if(x.getValue()==1){
                c++;
            }
            if(c==k){
                return x.getKey();
            }
        }
        return "";
    }
}