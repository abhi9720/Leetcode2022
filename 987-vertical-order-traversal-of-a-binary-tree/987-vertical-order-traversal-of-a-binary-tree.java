class Solution
{
    //Function to find the vertical order traversal of Binary Tree.
    static class pair implements Comparable<pair>{
        TreeNode node;
        int h;
        int d;
        pair(TreeNode node,int h,int d)
        {
            this.node=node;
            this.h=h;
            this.d=d;
        }
        public int compareTo(pair other){
            if(this.d == other.d){
                return this.node.val - other.node.val;
            } else {
                return this.d - other.d;
            }
        }
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
    
       LinkedList<pair>list = new LinkedList<>();
       HashMap<Integer,PriorityQueue<pair>>map=new HashMap<>();
       int min =0;
       int max=0;
       list.add(new pair(root,0,1));
       while(list.size()>0)
       {
           pair p = list.removeFirst();
           if(!map.containsKey(p.h)){
               map.put(p.h, new PriorityQueue<>());
               map.get(p.h).add( p );
           }
           else{
            map.get(p.h).add(p);
           }
           
           min=Math.min(min,p.h);
           max=Math.max(max,p.h);
           
           if(p.node.left!=null)
           {
               list.addLast(new pair(p.node.left,p.h-1,p.d+1));
           }
           if(p.node.right!=null)
           {
               list.addLast(new pair(p.node.right,p.h+1,p.d+1));
           }
       }
        
       List<List<Integer>>ans=new ArrayList<>();
       for(int i=min;i<=max;i++)
       {
        PriorityQueue<pair>p=map.get(i);
        ArrayList<Integer>a=new ArrayList<>();
        while(p.size()>0)
        {
            a.add(p.remove().node.val   );
        }
        ans.add(a);
       }
       return ans;

    }
}