class pair{
    int dist ;
    TreeNode root;
    pair(int dist, TreeNode root){
        this.dist =  dist;
        this.root =  root;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        
        Queue<pair> q =  new LinkedList<>();
        q.add(new pair( 0 , root ) );;        
        int maxWidth  = 0;
        while( q.size() >0 ){
            
            int size =  q.size();
            int minleftdist = 0;
            int maxRightdist =  0;
            for(int i=0;i<size;i++ ){
                pair parent  =  q.poll();
               
                TreeNode parentNode =  parent.root;
                int dist =  parent.dist;
                if(i==0){
                    minleftdist     =  dist;
                    
                }
                if(i==size-1) {
                    maxRightdist =  dist;
                    
                }

                if(parentNode.left!=null){
                    q.add( new pair(2*dist+1, parentNode.left ));
                }
                
                if(parentNode.right!=null){
                    q.add( new pair(2*dist+2, parentNode.right ));
                }                                
            }
            
            maxWidth = Math.max(maxRightdist-minleftdist+1, maxWidth );
            
            
        }
        return maxWidth;
        
        
        
    }
}