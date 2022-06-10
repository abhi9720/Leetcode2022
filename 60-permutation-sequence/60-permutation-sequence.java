import java.util.*;  
class Solution {
    public String getPermutation(int n, int k) {
        Vector<Integer> nums = new Vector<Integer>();  
        int fact = 1;
        for(int i=1;i<n;i++){
            fact =  fact*i;
            nums.add(i);        
        }
        nums.add(n);        
        StringBuilder sb =  new StringBuilder();
        k =  k-1;
        while(true){
            sb.append( nums.get( k / fact ) );
            nums.remove( nums.get( k / fact )  );
            if(nums.size()==0 ){
                break;
            }
            k =  k%fact;
            fact =  fact / nums.size();
        }
        
        
        return sb.toString() ;
    }
}