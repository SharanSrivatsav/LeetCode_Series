class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int i =0;
        int j=0;
        while(i<str1.length()&&j<str2.length()){
            while(i<str1.length()&&j<str2.length()&&str1.charAt(i)==str2.charAt(j)){
                i++;j++;
            }
            if(i==str1.length()||j==str2.length()){
                break;
            }
            if(nextChar(str1.charAt(i))==str2.charAt(j)){
                i++;j++;
            }
            else{
                i++;
            }
        }
        return (j==str2.length());
    }
    public char nextChar(char c){
        return (char)('a'+((c-'a'+1)%26));
    }
}