class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        Generator(n,temp,0,0,ans);
        return ans;
    }
    public static void Generator(int n , StringBuilder s ,int o , int c , List<String >ans){
        if(s.length()==2*n){
            ans.add(s.toString());
            return;
        }
        if(o<n){
            s.append('(');
            Generator(n,s,o+1,c,ans);
            s.deleteCharAt(s.length()-1);
        }
        if(c<o){
            s.append(')');
            Generator(n,s,o,c+1,ans);
            s.deleteCharAt(s.length()-1);
        }

    }
}