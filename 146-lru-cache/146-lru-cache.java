class LRUCache {
    
    public class Node{
        
        int key,value;
        Node prev,next;
        
    }
    
     
        HashMap<Integer,Node> hash;
        int cap;
        Node head;
        Node tail;
        int size=0;

    public LRUCache(int capacity) {
        
         hash=new HashMap<>();
         cap=capacity;
         head=new Node();
         tail=new Node();
        
        head.next=tail;
        tail.prev=head;
        
    }
    
    public int get(int key) {
        
        Node node=hash.get(key);
        
        if(node==null){
            return -1;
        }else{
            int val=node.value;
            moveToFront(node);
            return val;
        }
        
    }
    
    public void put(int key, int value) {
        
        Node node=hash.get(key);
        
        if(node==null){
            Node newNode=new Node();
            newNode.key=key;
            newNode.value=value;
            
            if(hash.size()==cap){
                Node LRU_Node=tail.prev;
                hash.remove(LRU_Node.key);
                remove(LRU_Node);
            }
            
            hash.put(key,newNode);//pay attention
            addFront(newNode);
        }else{
            node.value=value;
            moveToFront(node);
        }
        
    }
    
    
    //linkedlist functions:
    
    public void addFront(Node node){
        
        //node connect to head and head's next
        node.next=head.next;
        node.prev=head;
        
        
        //connecting all
        head.next.prev=node;
        head.next=node;
        
        size++;
        
        
        
    }
    
    public void remove(Node node){
        
      Node prvNbr=node.prev;
      Node nxtNbr=node.next;
        
     prvNbr.next=nxtNbr;
     nxtNbr.prev=prvNbr;
        
    node.next=node.prev=null;
        
     size--;
        
      
       
        
    }
    
    public void moveToFront(Node node){
    
        remove(node);
        addFront(node);
        
        
    }
}