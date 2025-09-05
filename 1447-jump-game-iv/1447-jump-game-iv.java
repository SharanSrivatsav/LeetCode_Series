class pair {
    int x;
    int y;

    pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int minJumps(int[] arr) {
        if (arr.length == 1) {
            return 0;
        }
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.computeIfAbsent(arr[i], v -> new ArrayList()).add(i);
        }
        // adjacency list is created
        Queue<pair> bq = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        int c = 0;
        bq.add(new pair(arr[0], 0));
        while (!bq.isEmpty()) {
            int s = bq.size();
            for (int j = 0; j < s; j++) {
                pair node = bq.poll();
                int val = node.x;
                int ind = node.y;
                if (node.y == arr.length - 1) {
                    return c;
                }
                if (ind + 1 < arr.length && !set.contains(ind + 1)) {
                    bq.add(new pair(arr[ind + 1], ind + 1));
                    set.add(ind + 1);
                }
                if (ind - 1 >= 0 && !set.contains(ind - 1)) {
                    bq.add(new pair(arr[ind - 1], ind - 1));
                    set.add(ind - 1);
                }
                if (map.containsKey(val)) {
                    for (int i : map.get(node.x)) {
                        if (set.contains(i)) {
                            continue;
                        }
                        bq.add(new pair(arr[i], i));
                        set.add(i);
                    }
                }
                map.remove(val);
            }
            c++;
        }
        return -1;
    }
}