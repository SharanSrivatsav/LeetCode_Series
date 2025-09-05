class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        int n = numCourses;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        int inDegree[] = new int[n];
        for (int c[] : prerequisites) {
            adj.get(c[0]).add(c[1]);
            inDegree[c[1]]++;
        }
        Map<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new HashSet<>());
        }
        Queue<Integer> tq = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                tq.add(i);
            }
        }
        while (!tq.isEmpty()) {
            int s = tq.size();
            for (int i = 0; i < s; i++) {
                int node = tq.poll();
                Set<Integer> temp = map.get(node);
                for (int j : adj.get(node)) {
                    map.get(j).add(node);
                    map.get(j).addAll(temp);
                    inDegree[j]--;
                    if (inDegree[j] == 0) {
                        tq.add(j);
                    }
                }
            }
        }
        List<Boolean> res = new ArrayList<>();
        for (int q[] : queries) {
           if(map.get(q[1]).contains(q[0])){
            res.add(true);
           }
           else{
            res.add(false);
           }
        }
        return res;
    }
}