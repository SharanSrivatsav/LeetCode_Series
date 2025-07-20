class Solution {
    int i = 0;

    // we need the index to be common for all recrusive calls and so we are making it global
    public int calculate(String s) {
        int val = 0;
        int num = 0;
        int sign = 1;
        while (i < s.length()) {
            if (s.charAt(i) == '(') {
                i++;
                val += sign * calculate(s);
            } else if (s.charAt(i) == ')') {
                i++;
                return val;
            } else if (Character.isDigit(s.charAt(i))) {
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = (num * 10) + (s.charAt(i) - '0');
                    i++;
                }
                val += sign * num;
                num = 0;
            } else if (s.charAt(i) == '+') {
                sign = 1;
                i++;
            } else if (s.charAt(i) == '-') {
                sign = -1;
                i++;
            } else if (s.charAt(i) == ' ') {
                i++; 
            }
        }
        return val;
    }
}