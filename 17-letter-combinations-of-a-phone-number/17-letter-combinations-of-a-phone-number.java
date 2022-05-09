class Solution {
    public List<String> letterCombinations(String digits) {
        
        List<String> ans =  new ArrayList<String>();
        if(digits.length()==0){
            return ans;
        }
        StringBuilder temp =  new StringBuilder();
        
         helper(digits,ans,temp,0);
        return ans;
    }   
    
    private void helper(String digit,List<String> ans  ,StringBuilder temp , int i ){
        if(temp.length() ==  digit.length()){
            ans.add( temp.toString() );
            return ;
        }
        char alpha[] = getAlpha(digit.charAt(i)-'0');
        for(int it=0;it<alpha.length;it++){
            
            temp.append( alpha[it]);            
            helper(digit,ans, temp ,i+1);
            temp.deleteCharAt(temp.length()-1);
            
        }
        
    }
    
    private char[] getAlpha(int d){
     
     String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
     return mapping[d].toCharArray();
        
    }
    
    
}