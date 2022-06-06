/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    
    public String serialize(TreeNode root) {
        StringBuilder sb  =  new StringBuilder();        
        serializeHelper(root,sb);
        
        
        return sb.toString();
    }
    private void serializeHelper(TreeNode root,StringBuilder sb){
        if(root==null){ 
            sb.append("#,") ;
            return ;
        }
        sb.append(root.val+",");
        serializeHelper(root.left,sb);
        serializeHelper(root.right,sb);                
    }
    int idx =  0;
    public TreeNode deserialize(String data) {
        if(data==null || data.length()==0 ) return null;
        this.idx = 0;
        String nodes[] =  data.split(",");
        return deserializeHelper(nodes);
    }
    private TreeNode deserializeHelper(String data[]){
        if(idx==data.length) return null;
        if(data[idx].equals("#") ) {
            idx++;
            return null;
        }
        TreeNode root =  new TreeNode(Integer.parseInt(data[idx]) );
        idx+=1;
        root.left = deserializeHelper(data);
        root.right = deserializeHelper(data);
        return root;            
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));