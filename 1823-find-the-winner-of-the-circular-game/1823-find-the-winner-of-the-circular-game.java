class Solution {
    public int findTheWinner(int n, int k) {
        return solution(n,k)+1;
    }
    
   public static int solution(int n, int k){
    if(n==0) return n;
    // int toadd =  k%n;
    int left  =  solution(n-1,k);
    // return (left+toadd)%n;
    return (left+k)%n;
    
  }
}