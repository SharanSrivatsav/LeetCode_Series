class Solution {
    public String maxValue(String n, int x) {
        char c = (char) ((int) '0' + x);
        StringBuilder res = new StringBuilder();
        boolean z = true;
        if (n.charAt(0)=='-') {
            // min finder
            for (char i : n.toCharArray()) {
                if (i == '-') {
                    res.append(i);
                    continue;
                }
                if (i > c && z) {
                    res.append(c);
                    z = false;
                }
                res.append(i);
            }
        } else {
            for (char i : n.toCharArray()) {
                if (i < c && z) {
                    res.append(c);
                    z = false;
                }
                res.append(i);
            }
        }
        if (z) {
            res.append(c);
        }
        return res.toString();
    }
}