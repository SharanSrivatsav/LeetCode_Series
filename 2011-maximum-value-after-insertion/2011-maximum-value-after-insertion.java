class Solution {
    public String maxValue(String n, int x) {
        char c = (char) ((int) '0' + x);
        StringBuilder res = new StringBuilder(n);
        boolean z = true;
        int ind =0;
        if (n.charAt(0)=='-') {
            // min finder
            for (char i : n.toCharArray()) {
                if (i == '-') {
                    ind++;
                    continue;
                }
                if (i > c) {
                    res.insert(ind,c);
                    return res.toString();
                }
                ind++;
            }
        } else {
            for (char i : n.toCharArray()) {
                if (i < c) {
                    res.insert(ind,c);
                    return res.toString();
                }
                ind++;
            }
        }
        res.append(c);
        return res.toString();
    }
}