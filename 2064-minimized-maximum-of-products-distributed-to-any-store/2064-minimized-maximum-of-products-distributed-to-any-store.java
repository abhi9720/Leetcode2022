class Solution {
    public int minimizedMaximum(int n, int[] arr) {
        int right = arr[0];
        
        for(int ele: arr) right =  Math.max(right,ele);
        
        int left = 1;
        int ans = 1;
        while(left <= right){
            int div = (right-left)/2+left;
            int sum = divideAndSum(arr,div);    
             if(sum <= n){
                ans =  div;
                right =  div-1;
            }
            else if(sum >n){
                left = div+1;
            }
        }
        return ans;
    }
    
    public int divideAndSum(int arr[] , int div){
        int sum = 0;
        for(int ele : arr){
            sum += ( ele/div + (ele%div==0?0:1) );
        }
        
        return sum;
    }
}

// 1 1 1 1 1 1 1
// 1 1 1 1 1 1 1
// 1
//   1 1 1 1 1 1
// 1 1 1 1
//         1 1 1
// 1 1 1 1 1 1 1
    
// -----------------
// 5 5 5 5 5 5 5
    

// 5 5 5 
//       5 5
//           5 5
    