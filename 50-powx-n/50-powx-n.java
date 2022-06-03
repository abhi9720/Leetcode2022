class Solution {
    public double myPow(double x, int n) {
        
        return helper(x,n);
        
    }
    private double helper(double x, int n){
        if(n<0){
            if(n==-1){
                return 1/x;
            }
            else{
                double ans =  helper(x,n/2);
                if(n%2==0) return ans*ans;
                else{
                    return ans*ans/x;
                }
            }
        }
        else{
            if(n==0) return 1;
            double ans =  helper(x,n/2);
            if(n%2==0){
                return ans*ans;
            }
            else{
                return ans*ans*x;
            }
        }
    }
}