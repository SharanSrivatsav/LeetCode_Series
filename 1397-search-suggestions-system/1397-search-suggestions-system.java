class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i <= searchWord.length(); i++) {
            String tup = searchWord.substring(0, i);
            generator(res, tup, products);
        }
        return res;
    }

    public static void generator(List<List<String>> res, String check, String prod[]) {
        if (check == "") {
            return;
        }
        int st = 0;
        int en = prod.length - 1;
        int stop = -1;
        while (st <= en) {
            int m = st + (en - st) / 2;
            if (prod[m].compareTo(check) >= 0) {
                stop = m;
                en = m - 1;
            } else {
                st = m + 1;
            }
        }
        List<String> temp = new ArrayList<>();
        if (stop == -1) {
            res.add(temp);
            return;
        }
        for (int i = stop; i < prod.length && temp.size() < 3; i++) {
            if (prod[i].startsWith(check)) {
                temp.add(prod[i]);
            } else {
                break;
            }
        }
        res.add(temp);
    }
}