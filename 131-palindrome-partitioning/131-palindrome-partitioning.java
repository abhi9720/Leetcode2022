class Solution {

    public List<List<String>> partition(String s) {
        List<List<String>> ans =  new ArrayList<>();
        partitionHelper(s,ans,new LinkedList<>() );
        return ans;
    }

    private void partitionHelper(String s, List<List<String>> ans, LinkedList<String> curr) {
        if (s.length() == 0) {
            ans.add(new ArrayList<String>(curr));
            return;
        }
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if(isPalindrome(s,0,i) ){
                curr.addLast( s.substring(0,i+1) );
                partitionHelper(s.substring(i+1) , ans,curr );
                curr.removeLast();
            }
        }
    }
    
    private boolean isPalindrome(String str, int s, int e){
        while(s<=e){
            if(str.charAt(s) != str.charAt(e)  ) return false;
            s+=1;
            e-=1;
        }
        return true;
    }
}
