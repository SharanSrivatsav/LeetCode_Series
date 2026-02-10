class Solution {
    public String removeDuplicateLetters(String s) {
        int freq[] = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        Set<Character> set = new HashSet<>();
        Stack<Character> stk = new Stack<>();
        for (char c : s.toCharArray()) {
            freq[c-'a']--;
            if (!set.contains(c)) {
                while (!stk.isEmpty() && stk.peek() > c && freq[stk.peek() - 'a'] >= 1) {
                    set.remove(stk.pop());
                }
                stk.add(c);
                set.add(c);
            }
        }
        StringBuilder res = new StringBuilder();
        while (!stk.isEmpty()) {
            res.append(stk.pop());
        }
        return res.reverse().toString();
    }
}