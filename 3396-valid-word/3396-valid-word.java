class Solution {
    public boolean isValid(String word) {
        if(word.length()<3){
            return false;
        }
        boolean dig= false;
        boolean vow = false;
        boolean cons =false;
        boolean up =false;
        boolean low =false;
        boolean others = false;
        for(char c : word.toCharArray()){
            if(Character.isDigit(c)){
                dig=true;
            }
            if(Character.isUpperCase(c)){
                up=true;
            }
            if((Character.isLowerCase(c))){
                low=true;
            }
            if(isVowel(c)){
                vow =true;
            }
            if(isCons(c)){
                cons=true;
            }
            if(!Character.isLetterOrDigit(c)){
                others =true;
            }
        }
        if(others){
            return false;
        }
        if((vow&&cons)){
            return true;
        }
        return false;
    }
    public static boolean isVowel(char x){
        return(x=='a'||x=='e'||x=='i'||x=='o'||x=='u'||x=='A'||x=='E'||x=='I'||x=='O'||x=='U');
    }
    public static boolean isCons(char x){
        if(!isVowel(x)&&Character.isLetter(x)){
            return true;
        }
        return false;
    }
}