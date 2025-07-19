class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        String prev= "";
        List<String> res = new ArrayList<>();
        for (String s : folder) {
            if(res.size()==0){
                res.add(s);
                continue;
            }
            if(res.size()>0){
            prev =res.get(res.size()-1);
            }
            if (res.size() > 0) {
                if (s.indexOf(res.get(res.size() - 1))!=-1&&s.charAt(s.indexOf(prev)+prev.length())=='/'&&s.indexOf(prev)==0) {
                    continue;
                }
            }
            res.add(s);
        }
        return res;
    }
}