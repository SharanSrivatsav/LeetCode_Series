class Spreadsheet {
    
      HashMap<String,Integer> map ;
    
    public Spreadsheet(int rows) { 
        map = new HashMap<>();
        
    }
    
    public void setCell(String cell, int value) {
        map.put(cell , value);
    }
    
    public void resetCell(String cell) {
        
        map.put(cell , 0);
    }
    
    public int getValue(String formula) {
        int idx = formula.indexOf('+');
        String s1 = formula.substring(1,idx);
        String  s2 = formula.substring(idx+1);
        int v1;
        int v2;
        if(map.containsKey(s1)){
            v1 = map.get(s1);
        }else{
            try{
                   v1 = Integer.parseInt(s1);
            }catch(Exception e){
                     v1 = 0;
            }
        } if(map.containsKey(s2)){
            v2 = map.get(s2);
        }else{
            try{
                   v2 = Integer.parseInt(s2);
            }catch(Exception e){
                     v2 = 0;
            }
        }
        
return v1+v2;       
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */