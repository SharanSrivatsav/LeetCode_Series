class Solution {
    public String frequencySort(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        PriorityQueue<Map.Entry<Character,Integer>> pq = new PriorityQueue<>((a,b)-> b.getValue()-a.getValue());
        pq.addAll(map.entrySet());
        StringBuilder res = new StringBuilder();
        while(!pq.isEmpty()){
            Map.Entry<Character,Integer> x = pq.poll();
            char c = x.getKey();
            int en = x.getValue();
            while(en-->0){
                res.append(c);
            }
        }
        return res.toString();
    }
}