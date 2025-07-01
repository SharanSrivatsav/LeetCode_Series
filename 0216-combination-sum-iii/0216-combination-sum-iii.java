class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        solver(res,temp,k,n,1,0);
        return res;
    }
    public static void solver(List<List<Integer>>res,List<Integer> temp,int k , int n , int st, int sum){
        if(temp.size()==k&&sum==n){
            res.add(new ArrayList<>(temp));
        }
        for(int i=st;i<10;i++){
            if(sum+i>n){
                break;
            }
            temp.add(i);
            solver(res,temp,k,n,i+1,sum+i);
            temp.remove(temp.size()-1);
        }
    }
}