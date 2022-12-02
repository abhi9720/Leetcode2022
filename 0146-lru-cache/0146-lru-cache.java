class LRUCache {
    DLL list;
    int size;
    HashMap<Integer,Node> cache;
    public void removeFromCache(int key){
        cache.remove(key);
    }
    
    public void addToCache(int ket, Node val){
        cache.put(ket, val);
    }
    
    public LRUCache(int capacity) {
        list = new DLL();
        cache =  new HashMap<>();
        this.size  =  capacity;
    }
    
    public int get(int key) {
        int val = -1 ;
        if(cache.containsKey(key) ){
            val = cache.get(key).data;
            list.removeNode(cache.get(key));
            Node rm =  cache.get(key);
            list.addFront(rm);
            cache.put(key , rm);                        
        }
        // System.out.println("value : "+val);
        // list.printList();
        return val;
    }
    
    public void put(int key, int value) {
        // System.out.println("key : "+key+"  -  value : "+value );
        if(cache.containsKey(key) ){
            Node rm =  cache.get(key);
            list.removeNode(rm);
            rm.data =  value;
            list.addFront( rm);
            cache.put(key , rm);
        }
        else{
            if(cache.size() == this.size ){
                Node rm  = list.removeFromEnd();
                cache.remove(rm.key);                
            }
            Node newNode = list.addFront(key ,value);
            cache.put(key , newNode);                
        }
        // list.printList();        
    }
}
class Node{
    int key;
    int data;
    Node prev , next;
    public Node(int key , int data){
        this.key =  key;
        this.data  =  data;
        this.prev =  null;
        this.next =  null;
    }
        
}

class DLL{
    Node head , tail;
    int size;
    public DLL(){
        head  =  tail= null;
        this.size = 0;
    }
    
    public void printList(){
        Node temp =  head;
        while(temp!=null){
            System.out.print(temp.data+" , ");
            temp =  temp.next;
        }
        System.out.println();
    }
    public Node addFront(int key,int data){
        Node newNode =  new Node(key ,data);
        if(head==null){
            head =  tail =  newNode;
        }
        else{
            newNode.next =  head;
            head.prev =  newNode;
            head =  newNode;                
        }            
        size++;
        return newNode;
    }
    
    public void removeNode(Node rm){

        if(head==tail){
            head =  tail =  null;
            size--;
        }
        else{
            
            if(rm==head){
              removeFromFront();
            }
            else if(rm==tail){
               removeFromEnd();
            }
            else{
                // System.out.println(rm.data);
                Node prv =  rm.prev;
                Node next =  rm.next;
                
                rm.prev = null;
                rm.next = null;
                
                prv.next =  next;
                next.prev = prv;
                
                size--;
            }
        }        
    }
    
    public Node addFront(Node newNode){
        
        if(head==null){
            head =  tail =  newNode;
        }
        else{
            newNode.next =  head;
            head.prev =  newNode;
            head =  newNode;                
        }            
        size++;
        return newNode;
    }
    
     public void removeFromFront(){
        head =  head.next;
        head.prev.next = null;
        head.prev = null;
         size--;
     }
    
    
    public Node removeFromEnd(){        
        Node rmNode = null;
        if(head==tail) {
            rmNode =  tail;
            head =  tail = null;
        }
        else{
            rmNode =  tail;
        
            Node preTail =  tail.prev;
            preTail.next =  null;
            tail.prev = null;

            tail =  preTail;                
        }
        
        size--;
        
        return rmNode;
    }
    
    public int size(){
        return this.size;
    }
    
    public boolean isEmpty(){
        return size==0;
    }
    
}

