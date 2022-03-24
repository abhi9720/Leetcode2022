class MyLinkedList {
    
    class Node{
        
        int data;
        Node pre , next ;
        Node() {
            this.data = -1;
            this.pre =  null;
            this.next =  null;
        }
    }
    

    Node head ,tail;
    int size=0;
    public MyLinkedList() {
        this.head =  new Node();
        this.tail =  new Node();
        
        head.next =  tail;
        tail.pre  =  head;
        
        this.size =  0;
    }
    
    public int get(int index) {
        if(index > size) return -1;
        
            Node temp = head.next;
            int i=0;
            while(temp!=null && i<index){
                temp =  temp.next;
                i++;
            }
            return temp.data;
        
    }
    
    public void addAtHead(int val) {
        Node newNode =  new Node();
        newNode.data =  val;
        
        Node after =  head.next;
        
        newNode.next = after;
        after.pre =  newNode;
        
        head.next =  newNode;
        newNode.pre =  head;
        size++;
        
    }
    
    public void addAtTail(int val) {
        Node newNode =  new Node();
        newNode.data =  val;
        
        Node before =  tail.pre;
        
        before.next =  newNode;
        newNode.pre =  before;
        
        newNode.next =  tail ;
        tail.pre =  newNode;
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if(index>size){
            return ;
        }        
        
        Node newNode =  new Node();
        newNode.data =  val;
        
        Node temp =  head; int i=0;
        while(i<index){
            temp =  temp.next;
            i++;
        }
        
        temp.next.pre =  newNode;
        
        newNode.next  =  temp.next;
        newNode.pre =  temp;
        
        temp.next =  newNode;
        size++;
        
    }
    
    public void deleteAtIndex(int index) {
        if(index >= size) return ;
        Node temp =  head;
        int i = 0;
        while(temp!=null && i <= index){
            temp = temp.next;
            i++;
        }
        Node preNode =  temp.pre;
        Node nextNode =  temp.next;
        preNode.next =  nextNode;
        nextNode.pre =  preNode;
        size-=1;
    }
}

 