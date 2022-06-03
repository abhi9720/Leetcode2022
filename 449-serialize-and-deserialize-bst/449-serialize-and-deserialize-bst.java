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
        if(root==null) return null;
        StringBuilder sb =  new StringBuilder();
        
        serializeHelper(root,sb);
        
        int size =  sb.length();                
        sb.deleteCharAt(size-1);
        
        return sb.toString();
        
    }
    private void serializeHelper(TreeNode root,StringBuilder sb){
        if(root==null) return ;
                
        sb.append(root.val+",");        
        serializeHelper(root.left,sb);                        
        serializeHelper(root.right,sb);        
    }
    
    int idx = 0;
    TreeNode deserializeHelper(String nums[],int min , int max){
       if(idx>=nums.length) return null;
        int num =  Integer.parseInt(nums[idx] );
        if(num>min && num<max){
            TreeNode root =  new TreeNode(num );
            idx+=1;
            root.left =  deserializeHelper(nums,min,num);
            root.right =  deserializeHelper(nums,num,max);
            return root;
        }
        else{
            return null;
        }        
    }
    
    public TreeNode deserialize(String data) {
        if(data==null) return null;
        String nums[] =  data.split(",");        
        
        return  deserializeHelper(nums,Integer.MIN_VALUE,Integer.MAX_VALUE);
        
    }
    
}
