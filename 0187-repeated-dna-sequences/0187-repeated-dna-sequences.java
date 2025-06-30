class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() <=10) {
            return new ArrayList<>();
        }
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String temp = s.substring(i, i + 10);
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }
        List<String> ans = new ArrayList<>();
        for (String u : map.keySet()) {
            if (map.get(u) > 1) {
                ans.add(u);
            }
        }
        return ans;
    }
}