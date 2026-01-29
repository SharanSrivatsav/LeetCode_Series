class Solution {
    public String decodeAtIndex(String s, int k) {
        long len = 0 ;
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                int num = c-'0';
                len*=num;
            }
            else{
                len++;
            }
        }
        for(int i= s.length()-1;i>=0;i--){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                long num = c-'0';
                // The String is repeated 'c' times so we are reducing the string len by dividing
                len/= num;
                // the string may repeated 'c' number of times so the K here might be very large 
                // here we are placing the K at its exact position by modulo-ing with the original copy length(current-copy)
                // while modulo-ing for 'c' times repeatation is neglected as we modulo it with the current length
                // example let's say 7 is K and the len becomes 4 and previously len was 12 
                // now the 7th character is exact same of the 4th character as the OG length is 4
                // since we cannot access index '7' we are reducing it to '3' by modulo-ing it with the OG length
                k%=len;
            }
            else{
                if(k==0||k==len){
                    return ""+c;
                }
                else{
                    len--;
                }
            }
        }
        return ""; 
    }
}