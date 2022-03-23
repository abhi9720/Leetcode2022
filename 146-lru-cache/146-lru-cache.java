
class LRUCache {
	 class Node{
	        Node pre , next;
	        int key ,  value;
	        Node(int k , int v){
	            this.key =  k;
	            this.value = v;
	        }
	      
	    }
        
   
	    
	    HashMap<Integer,Node> map;
	    Node head, tail;
	    int size ;     
	    int capacity;
	    
	    void addFront(int key,int val){
	        Node newNode =  new Node(key,val);
	        if(head==null){
	            head =  tail =  newNode;            
	        }else{
	            newNode.next = head;
	            head.pre =  newNode;
	            head = newNode;
	        }
	        size++;
	    }
	    
	    void remove(Node address ){
	        // also remove from map 
	        if(size==1){
	            head =  tail = null;	            
	        }
            else if(address==head){
              head =  head.next;
                head.pre =  null;
            }
            else if(address==tail){
                // removelast();
                // return ;
                
                Node nm1 = address.pre;
                nm1.next =  null;
                tail.pre = null;
                tail =  nm1;
            }
            else {
	            Node nm1 = address.pre;
	            Node np1 =  address.next;
               
	            nm1.next =  np1;
	            if(np1!=null){
	                np1.pre =  nm1;
	            }
                
	        }
	        size-=1;
	        
	    }
	    void removelast(){
	        // it return key of removed node 
	    	if(head==null ) return;
	    	int key =  tail.key;
	    	map.remove(key);
	        if(head==tail){	            
	        	head =  tail =  null;	            
	        }else{
	            // left will nm1
	            tail =  tail.pre;
	        }
	        size-=1;
	        
	    }
	   
	    
	    
	    public LRUCache(int capacity) {
	        map = new HashMap<>();
	        this.capacity =  capacity;
	        this.size = 0;
	        this.head =  null;
	        this.tail =  null;        
	    }
	    
	    public int get(int key) {
            // System.out.println(" get : "+key);
            
	        if(map.containsKey(key) ){
	            Node address =  map.get(key);	            
	            // get value 
	            // remove from linked list
	            // add at front 
	            // update address in map
	            int val = address.value;            
	            remove(address);            
	            addFront(key,val) ;                        
	            map.put(key , head);
               
	            return val;
	        }else{
                
	            return -1;
	        }        
          
	    }
	    
	    public void put(int key, int value) {
            
	        /*
	        case possible with put
	        1. already present 
	        2. not present 
	            2.1 if cache size is full
	            2.2 cache have empty space 
	        */
	        if(map.containsKey(key) ){
	            // update value 
	            // remove 
	            // add at front
	            // update address 
	            Node Address =  map.get(key);
	            remove(Address);
	            map.remove(key);	            
	        }
	        else if( size == capacity ){
	            // remove lastnode of linked list
	            // add at front 
	            // insert address in hashmap
	        	removelast();	            
	        }else{
	            // add at front 
	            // insert address in hashmap
	        }
	        addFront(key,value);
	        map.put(key,head);
	         // add at front
	         // update address 
            
	    }
}
