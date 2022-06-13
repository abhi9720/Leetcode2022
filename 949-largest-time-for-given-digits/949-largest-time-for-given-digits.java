class Solution {
    public String largestTimeFromDigits(int[] arr) {
        String ans = "";
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                for(int k =0;k<4;k++){
                    if(i==j || j==k || k==i) continue;
                    int l =  6-i-j-k;
                    String HH  =  ""+arr[i]+arr[j];
                    String MM =  ""+arr[k]+arr[l];
                    String newTime =  HH+":"+MM;
                    if(HH.compareTo("24") <0 && MM.compareTo("60") <0 ){
                        if(newTime.compareTo(ans) >0 ){
                            ans =  newTime;
                        }
                    }
                }
            }
        }
        return ans;
            
    }
}