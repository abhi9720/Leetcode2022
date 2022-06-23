

class Solution {
    public int maxDepth(Node root) {
        if(root==null) return 0;
        int max1 =  0 ;
        for(Node child : root.children){
            int h = maxDepth(child);
            if(h > max1){                
                max1 = h;
            }            
        }
        return 1+max1;
    }
}