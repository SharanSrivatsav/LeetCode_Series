class Solution {
    public char nextGreatestLetter(char[] let, char tar) {
        int st = 0;
        int en = let.length - 1;
        char res = let[0];
        while (st <= en) {
            int m = st + (en - st) / 2;
            if (let[m] > tar) {
                res = let[m];
                en = m - 1;
            } else {
                st = m + 1;
            }
        }
        return res;
    }
}