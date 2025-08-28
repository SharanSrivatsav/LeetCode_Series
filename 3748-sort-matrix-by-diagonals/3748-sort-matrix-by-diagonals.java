class Solution {
    public int[][] sortMatrix(int[][] grid) {
        Map<Integer,ArrayList <Integer>> map =  new HashMap<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!map.containsKey(i-j)){
                    map.put(i-j, new ArrayList<>());
                }
            }
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                map.get(i-j).add(grid[i][j]);
            }
        }
        for(int k : map.keySet()){
            if(k>-1){
                Collections.sort(map.get(k),(a,b) -> b-a);
            }
            else{
                Collections.sort(map.get(k));
            }
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                int val = map.get(i-j).get(0);
                grid[i][j]=val;
                map.get(i-j).remove(0);
            }
        }
        return grid;
    }
}