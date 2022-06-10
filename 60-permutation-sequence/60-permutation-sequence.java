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
        // factorial one less than from n beacause 
        /*
            [1,2,3,4 ] , k =  17
            1 +( 2,3,4 ) => taking 1 as fixed , 6 permuatation possible
            2 +( 1,3,4 ) => taking 1 as fixed , 6 permuatation possible
            3 +( 1,2,4 ) => taking 1 as fixed , 6 permuatation possible
            and 17th permuation lies in this range ^  , taking 3 as fixed
                                                   
                                                   
            4 +( 1,2,3 ) => taking 1 as fixed , 6 permuatation possible
            
            next set k =  
        */

        StringBuilder sb =  new StringBuilder();
        k =  k-1;
        while(true){
            int idx = k/fact;
            sb.append( nums.get(idx) );
            nums.remove( nums.get( idx )  );
            if(nums.size()==0 ){
                break;
            }
            k =  k%fact;            
            fact =  fact / nums.size();
        }
        
        
        return sb.toString() ;
    }
}