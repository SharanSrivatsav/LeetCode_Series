class Solution {
    public int minimumLength(String s) {
        if(s.length()==1){
            return 1;
        }
        int st = 0;
        int en = s.length()-1;
        if(s.charAt(st)!=s.charAt(en)){
            return s.length();
        }
        while(st<en){
           char c = s.charAt(st);
           if(s.charAt(st)!=s.charAt(en)){
             break;
           }
           while(st<=en&&s.charAt(st)==c){
            st++;
           }
           while(st<=en&&s.charAt(en)==c){
            en--;
           }
        }
        return en-st+1;
    }
}