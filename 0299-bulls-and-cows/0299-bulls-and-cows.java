class Solution {
    public String getHint(String secret, String guess) {
        int freq [] = new int [10];
        for(char c :secret.toCharArray()){
            freq[c-'0']++;
        }
        int cow=0;
        for(char c : guess.toCharArray()){
            if(freq[c-'0']!=0){
                freq[c-'0']--;
                cow++;
            }
        }
        int bull =0;
        for(int i=0;i<secret.length();i++){
            if(secret.charAt(i)==guess.charAt(i)){
                bull++;
            }
        }
        cow = cow-bull;
        return bull+"A"+cow+"B";
    }
}