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
        while( lower<higher  ){
            int mid =  lower+(higher-lower)/2;
            int response =  guess(mid);
            // compress left boundary 
            if(response==1){
             lower =  mid+1;   
            }else{
                higher =  mid;
            }
            
        }
        return higher;
        
    }
}