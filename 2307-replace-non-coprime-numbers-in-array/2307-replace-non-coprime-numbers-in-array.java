class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            long val = nums[i];
            while (!stk.isEmpty() && gcd(stk.peek(), val) != 1) {
                val = (lcm(stk.pop(), val));
            }
            stk.push((int) val);
        }
        List<Integer> res = new ArrayList<>(stk);
        return res;
    }

    long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    long gcd(long a, long b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }
}