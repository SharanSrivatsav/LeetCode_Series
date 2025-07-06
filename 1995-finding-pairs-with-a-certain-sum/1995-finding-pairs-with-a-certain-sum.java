class FindSumPairs {
     int arr1[];
     int arr2[];
    Map<Integer, Integer> map;

    public FindSumPairs(int[] nums1, int[] nums2) {
        arr1 = nums1;
        arr2 = nums2;
        map = new HashMap<Integer, Integer>();
        for (int i : nums2) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
    }

    public void add(int index, int val) {
        map.put(arr2[index], map.get(arr2[index]) - 1);
        int num = arr2[index] + val;
        arr2[index] = num;
        map.put(num, map.getOrDefault(num, 0) + 1);
    }

    public int count(int tot) {
        int c = 0;
        for (int i :arr1) {
            int val = tot - i;
            if (map.containsKey(val)) {
                c += map.get(val);
            }
        }
        return c;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */