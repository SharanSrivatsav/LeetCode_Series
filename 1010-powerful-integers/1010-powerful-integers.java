class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        if(bound<2){
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        // for 1st power we are adding all possible powers of y value that is bound
        // if we take x^0 how much can we accomodate from y^0,y^1,.....y^n 
        // such that the sum always less than or equal to "bound"
        for(int i = 1;i<bound;i=i*x){
            for(int j=1;j+i<=bound;j=j*y){
                if(!list.contains(i+j)){
                    list.add(i+j);
                }
                if(y==1) break;
            }
            if(x==1) break;
        }
        return list;
    }
}