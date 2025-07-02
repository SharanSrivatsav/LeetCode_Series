class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        List<String> temp =  new ArrayList<>();
        solver(0,ans,temp,s);
        return ans;
    }
    public static void solver(int st,List<String> ans,List<String> temp, String s){
        if(temp.size()==4&&st==s.length()){
            StringBuilder res = new StringBuilder();
            for(String p :temp){
                res.append(p);
                res.append(".");
            }
            res.deleteCharAt(res.length()-1);
            ans.add(res.toString());
        }
        if(temp.size()>=4&&st<s.length()){
            return;
        }
        for(int i=st;i<s.length();i++){
            String ss =  s.substring(st,i+1);
            if(isVal(ss)){
                temp.add(ss);
                solver(i+1,ans,temp,s);
                temp.remove(temp.size()-1);
            }
        }
    }
    public static boolean isVal(String s ){
        if(s.length()>3||s.length()>1&&s.charAt(0)=='0'){
            return false;
        }
        if(Integer.parseInt(s)>255){
            return false;
        }
        return true;
    }
}