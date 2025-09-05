class State {
    char c;
    int[] pos;

    State(char c, int n) {
        this.c = c;
        this.pos = new int[n];
    }
}

class Solution {
    public String rankTeams(String[] votes) {
        if(votes.length==1){
            return votes[0];
        }
        if (votes == null || votes.length == 0) {
             return "";
        }
        int n = votes[0].length();
        State[] arr = new State[26];
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            arr[ch - 'A'] = new State(ch, n);
        }

        for (String vote : votes) {
            for (int i = 0; i < vote.length(); i++) {
                arr[vote.charAt(i) - 'A'].pos[i]++;
            }
        }

        Arrays.sort(arr, (a, b) -> {
            for (int i = 0; i < n; i++) {
                if (a.pos[i] != b.pos[i]) return b.pos[i] - a.pos[i];
            }
            return a.c - b.c;
        });

        StringBuilder res = new StringBuilder();
        for (State s : arr) {
            if(votes[0].indexOf(s.c)!=-1)
            res.append(s.c);
        }

        return res.toString();
    }
}
