class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        // topological sort
        List<HashSet<Integer>> hs = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            hs.add(new HashSet<>());
            adj.add(new ArrayList<>());
        }
        int inDegree[] = new int[n];
        for (int a[] : edges) {
            adj.get(a[0]).add(a[1]);
            inDegree[a[1]]++;
        }
        Queue<Pair> bq = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                bq.add(new Pair(i, -1));
            }
        }
        while (!bq.isEmpty()) {
            Pair node = bq.poll();
            for (int i : adj.get(node.x)) {
                inDegree[i]--;
                hs.get(i).add(node.x);
                hs.get(i).addAll(hs.get(node.x));
                if (inDegree[i] == 0) {
                    bq.add(new Pair(i, node.x));
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> t =  new ArrayList<>();
            for(int j :hs.get(i)){
                t.add(j);
            }
            Collections.sort(t);
            res.add(t);
        }
        return res;
    }
}