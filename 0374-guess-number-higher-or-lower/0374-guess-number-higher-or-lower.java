/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int st =1;
        int en = n;
        int ans= 0;
        while(st<=en){
            int m = st+(en-st)/2;
            int g = guess(m);
            if(g==0){
               ans=m;
               break; 
            }
            else if(g==-1){
                en=m-1;
            }
            else{
                st=m+1;
            }
        }
        return ans;
    }
}