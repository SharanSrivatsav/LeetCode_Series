class Solution {
    public int possibleStringCount(String word) {
        int c = 1; // we are keeping the c itself as 1
        // because there is chance that given string migth be the original one
        for(int i = word.length()-1;i>=1;i--){
             if(word.charAt(i)==word.charAt(i-1)){
                c++;
             }
        }
        return c;
    }
}