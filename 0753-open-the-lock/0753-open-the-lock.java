class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> ded = new HashSet<>();
        for (String s : deadends) {
            ded.add(s);
        }
        String start = "0000";
        if(ded.contains(start)){
            return -1;
        }
        Queue<String> bq = new LinkedList<>();
        bq.add(start);
        int c = 0;
        while (!bq.isEmpty()) {
            int en = bq.size();
            for (int i = 0; i < en; i++) {
                String val = bq.poll();
                if (val.equals(target)) {
                    return c;
                }
                // we need to generate all the neighbouring Strings
                for (String t : nearGen(val)) {
                    if (ded.contains(t)) {
                        continue;
                    }
                    bq.add(t);
                    ded.add(t);
                }
            }
            c++;
        }
        return -1;
    }

    public List<String> nearGen(String s) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char x[] = s.toCharArray();
            char y[] = s.toCharArray();
            // back generator
            if (x[i] == '0') {
                x[i] = '9';
            } else {
                x[i]--;
            }
            res.add(new String(x));
            // forward generator
            if (y[i] == '9') {
                y[i] = '0';
            } else {
                y[i]++;
            }
            res.add(new String(y));
        }
        return res;
    }
}