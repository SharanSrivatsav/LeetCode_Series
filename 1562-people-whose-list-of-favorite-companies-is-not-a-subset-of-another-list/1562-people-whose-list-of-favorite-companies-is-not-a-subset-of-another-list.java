class Solution {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        List<Integer> res = new ArrayList<>();
        int val= 1;
        Map<String,Integer> map =  new HashMap<>();
        for(List<String> temp :favoriteCompanies){
            for(String s: temp){
                map.putIfAbsent(s,val++);
            }
        }
        //company and its value is created
        int idx =0;
        Map<Integer,int []> value =  new HashMap<>();
        for(List<String> temp :favoriteCompanies){
            int n = temp.size();
            int arr [] = new int [n];
            int p=0;
            for(String s : temp){
                arr[p++]=map.get(s);
            }
            value.put(idx++,arr);
        }
        int poo=0;
        for(Map.Entry<Integer , int []> x : value.entrySet()){
            boolean isSubset = false;
            for(Map.Entry<Integer , int []> y : value.entrySet()){
                if(x.getKey()==y.getKey()){
                    continue;
                }
                int c1 [] = x.getValue();
                int c2 [] = y.getValue();
                if(check(c1,c2)){
                    isSubset=true;
                    break;
                }
            }
            if(!isSubset){
                res.add(poo);
            }
            poo++;
        }
        return res;
    }
    public boolean check (int arr1 [], int arr2 []){
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 =  new HashSet<>();
        for(int i: arr1) set1.add(i);
        for(int i :arr2) set2.add(i);
        return set2.containsAll(set1);
    }
}