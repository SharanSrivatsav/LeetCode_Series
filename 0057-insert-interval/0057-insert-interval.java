class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int i = 0;
        List<int[]> res = new ArrayList<>();
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }
        int min = newInterval[0];
        int max = newInterval[1];
        // overlapping area
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            min = Math.min(min,intervals[i][0]);
            max = Math.max(max,intervals[i][1]);
            i++;
        }
        res.add(new int[]{min, max});
        // remaining portion
        while(i<intervals.length){
            res.add(intervals[i++]);
        }
        return res.toArray(new int[res.size()][]);
    }
}