/**/

class Solution {

    public List<List<String>> partition(String s) {
        List<List<String>> ans =  new ArrayList<>();
        partitionHelper(s,0,ans,new LinkedList<>() );
        return ans;
    }

    private void partitionHelper(String s,int idx, List<List<String>> ans, LinkedList<String> curr) {
        if (idx == s.length()) {
            ans.add(new ArrayList<String>(curr));
            return;
        }
        int n = s.length();
        for (int i = idx; i < n; i++) {
            if(isPalindrome(s,idx,i) ){
                curr.addLast( s.substring(idx,i+1) );
                partitionHelper(s ,i+1, ans,curr );
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
