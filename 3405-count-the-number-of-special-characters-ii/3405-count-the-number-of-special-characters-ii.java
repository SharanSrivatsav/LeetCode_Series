class Solution {
    public int numberOfSpecialChars(String word) {
        int small [] = new int [26];
        int caps [] =  new int [26];
        int j=1;
        for(char c : word.toCharArray()){
            if(Character.isUpperCase(c)&&caps[c-'A']==0){
                caps[c-'A']=j;
            }
            else if(Character.isLowerCase(c)){
                small[c-'a']=j;
            }
            j++;
        }
        int count =0;
        for(int i=0;i<26;i++){
            if(small[i]>0&&small[i]<=caps[i]){
                count++;
            }
        }
        return count ;
    }
}