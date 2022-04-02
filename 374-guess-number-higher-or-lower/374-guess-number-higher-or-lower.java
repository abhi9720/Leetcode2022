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
     int lower =  1, higher =  n;
        while( lower<=higher  ){
            int mid =  lower+(higher-lower)/2;
            int response =  guess(mid);
            if(response==0) return mid;
            else if(response == -1){
                // compress right boundary 
                higher = mid-1;
            }else{
                lower  =  mid+1;
            }
            
        }
        return -1;
        
    }
}