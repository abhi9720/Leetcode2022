class LRUCache {
    class Node{
        Node next , pre;
        int key , value;
        Node(int key , int value){
            this.key =  key;
            this.value =  value;
            
        }
        Node(){
            this.key =  -1;
            this.value = -1;
        }
    }

    HashMap<Integer,Node> map;
    Node head  , tail;
    int size , capacity;
    
    public LRUCache(int capacity) {
        this.capacity =  capacity;
        this.size = 0;
        head =  new Node();
        tail =  new Node();
        head.next =  tail;
        tail.pre = head;      
        map =  new HashMap<>();
    }
    
    private void remove(Node node ){
       node.next.pre =  node.pre;
       node.pre.next =  node.next;
        map.remove(node.key);
        // print();
        
    }
    private void addAtFront(Node node){
        
        Node after =  head.next;
        node.pre =  head;
        node.next =  after;
        
        head.next =  node;
        node.next.pre =  node;
    }
    
    
    public int get(int key) {
        
        Node address =  map.get(key);
        if(address==null){ 
            // print();
            return -1;
        }
        else{
            int val =  address.value;
            remove(address);
            addAtFront(address);   
            map.put(key,head.next);    
            // print();
            return val;
        }        
    }
    
    public void put(int key, int value) {
        
        // three cases possible
        // check it exists or not
        // if exists  -  then update value, remove  and add at front
        // if not exists 
        //    then size < capacity  , add at front        
        // if size== capacity first remove then add at front 
        // and final update hashmap 
        
        Node node =  map.get(key);        
        if(node!=null){ // exists
            node.value =  value;
            remove(node);
           
        }else if(capacity == size){ // not exists , cache full
            node =  new Node();
            node.key =  key;
            node.value  =  value;
            Node lastNode =  tail.pre;
            // System.out.println("deleting : "+tail.pre.key);
            remove(lastNode);// remove last
            
           
        }else{ // not exists cache empty
            node =  new Node();
            node.key =  key;
            node.value  =  value;     
            size++;
        }
        addAtFront(node);
        map.put(key,head.next);     
        // print();
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */