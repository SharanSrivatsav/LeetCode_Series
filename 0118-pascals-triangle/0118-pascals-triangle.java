class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> x = new ArrayList<>();
        x.add(Arrays.asList(1));
        for(int i=1;i<numRows;i++){
            x.add(new ArrayList<Integer>());
           for(int j=0;j<=i;j++){
            if(j==0||j==i){
                x.get(i).add(1);
            }
            else{
                Integer p=x.get(i-1).get(j-1);
                Integer q=x.get(i-1).get(j);
                x.get(i).add(p+q);
            }
           }
        }
        return x;
    }
}