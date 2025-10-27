class Solution {
    public int numberOfBeams(String[] bank) {
        int ans = 0;
        for (int i = 0; i < bank.length - 1; i++) {
            String a = bank[i];
            int c1 = noOfOnes(a);
            int c2 = 0 ;
            while (true&&i<bank.length-1) {
                String b = bank[i + 1];
                c2 = noOfOnes(b);
                if(c2!=0){
                    break;
                }
                i++;
            }
            ans += (c1 * c2);
        }
        return ans;
    }

    public int noOfOnes(String s) {
        char x[] = s.toCharArray();
        int c = 0;
        for (char t : x) {
            if (t == '1') {
                c++;
            }
        }
        return c;
    }
}