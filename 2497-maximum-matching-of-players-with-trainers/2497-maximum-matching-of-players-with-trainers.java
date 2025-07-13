class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int c = 0;
        Arrays.sort(players);Arrays.sort(trainers);
        int i=0;int j=0;
        while(i<players.length&&j<trainers.length){
            if(players[i]<=trainers[j]){
                i++;j++;
                c++;
            }
            else{
                j++;
            }
        }
        return c;
    }
}