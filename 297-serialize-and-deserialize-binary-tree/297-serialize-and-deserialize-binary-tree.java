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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb =  new StringBuilder();
        serializeHelper(root,sb);
        int size =  sb.length();
        
        // sb.deleteCharAt(size-1);
        
        return sb.toString();
        
    }
    private void serializeHelper(TreeNode root,StringBuilder sb){
        if(root==null) return ;
        
        sb.append(root.val+",");
        
        if(root.left==null) sb.append("#,");
        else serializeHelper(root.left,sb);                
        if(root.right==null) sb.append("#,");
        else serializeHelper(root.right,sb);        
    }
    int idx = 0;
    TreeNode deserializeHelper(String nums[]){
        if(idx>=nums.length) return null;
        if(nums[idx].trim().equals("#") ){
            
            idx+=1;
            return null;
        }
        // System.out.println("nums[idx] : "+nums[idx]);
        TreeNode root =  new TreeNode(Integer.parseInt(nums[idx] ) );
        idx+=1;
        // System.out.println("root.val : "+root.val);
        root.left = deserializeHelper(nums);
        root.right = deserializeHelper(nums);
        return root;
    }
    
    public TreeNode deserialize(String data) {
        String nums[] =  data.split(",");
        if(nums.length==1 ) return null;
        
        return  deserializeHelper(nums);
        
    }
    
}