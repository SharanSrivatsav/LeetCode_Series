class pair {
    int x;
    int y;

    pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        // int n = difficulty.length;
        // pair diff [] = new pair[n];
        // int max=0;
        // for(int i=0;i<n;i++){
        //     max = Math.max(max,profit[i]);
        //     diff[i]=new pair(difficulty[i],max);
        // }
        // Arrays.sort(diff, (a,b)-> a.x-b.x);
        int n = difficulty.length;
        pair[] diff = new pair[n];
        for (int i = 0; i < n; i++) {
            diff[i] = new pair(difficulty[i], profit[i]); // raw values first
        }

        Arrays.sort(diff, (a, b) -> a.x - b.x); // sort by difficulty first
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, diff[i].y); // compute prefix max now
            diff[i].y = max;
        }
        int prof = 0;
        for (int i = 0; i < worker.length; i++) {
            int val = worker[i];
            int ind = binSearch(diff, val);
            if (ind != -1)
                prof += ind;
        }
        return prof;
    }

    public static int binSearch(pair[] arr, int val) {
        int st = 0;
        int en = arr.length - 1;
        int ans = -1;
        while (st <= en) {
            int m = (st + en) / 2;
            if (arr[m].x <= val) {
                ans = arr[m].y;
                st = m + 1;
            } else {
                en = m - 1;
            }
        }
        return ans;
    }
}