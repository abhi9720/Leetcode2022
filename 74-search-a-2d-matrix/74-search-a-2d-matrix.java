class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n  =  matrix.length , m =  matrix[0].length;
        int i = 0 , j =  matrix[0].length-1;
        while(i< n){
            if( target > matrix[i][j]  ){
                i+=1;
            }
            else{
                int idx =  binarySearch(matrix[i],target);
                
                if(idx==-1) return false;
                else return true;
            }                   
        }
        return false;
        
    }
    
    private int binarySearch( int arr[] , int target){
        int i = 0  , j =  arr.length-1;
        while(i<=j){
            int m  =  i+(j-i)/2;
            
            if(arr[m]==target){
                return m;
            }else if( arr[m] > target ){
                j =  m-1;
            }
            else{
                i =  m+1;
            }
        }
        return -1;
    }
}