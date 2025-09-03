class Solution {
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[arr.length];

        q.offer(start);
        vis[start] = true;

        while (!q.isEmpty()) {
            int idx = q.poll();

            if (arr[idx] == 0) return true;

            int left = idx - arr[idx];
            int right = idx + arr[idx];

            if (left >= 0 && !vis[left]) {
                q.offer(left);
                vis[left] = true;
            }

            if (right < arr.length && !vis[right]) {
                q.offer(right);
                vis[right] = true;
            }
        }
        return false;
    }
}
