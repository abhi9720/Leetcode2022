/*
Break our problem to smaller problem
-----------------------
like for n =  7        |
left root right        |
1     1     5          |
3     1     3          |
5     1     1          |
-----------------------    
like for n = 5         |
left root right        |
1     1     3          |
3     1     1          | 
-----------------------
like for n = 3         |
left root right        |
1     1     1          |
1     1     1          |
-----------------------
like for n = 1         |
left root right        |
null   1   null        |
-----------------------

*/
class Solution {
    public List<TreeNode> allPossibleFBT(int n) {
        
        if(n%2==0) return new ArrayList<TreeNode>();
        List<TreeNode> res =  new ArrayList<>();
        if( n==1 ) {
            res.add(new TreeNode(0) );
            return res;
        }
        
        for(int i=1;i<n;i++){
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(n-i-1);
            
            for(TreeNode ln : left){
                for(TreeNode rn : right){
                    TreeNode curr =  new TreeNode(0);
                    curr.left =  ln;
                    curr.right =  rn;
                    res.add(curr);
                }
            }                            
        }        
        return res;        
    }
}