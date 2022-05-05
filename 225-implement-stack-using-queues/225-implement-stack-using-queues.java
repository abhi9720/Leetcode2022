class MyStack {

    Queue<Integer> q1 ,q2;
    int size = 0;
    public MyStack() {
        q1 =  new ArrayDeque<>();
        q2 =  new ArrayDeque<>();        
    }
    
    public void push(int x) {
        while(!q1.isEmpty ()){
            q2.offer(q1.poll());
        }
        q1.offer(x);
        while(!q2.isEmpty() ){
            q1.offer(q2.poll());
        }
    }
    
    public int pop() {
        if(q1.size()!=0 ) return q1.remove();
        else return -1;
        
    }
    
    public int top() {
        if(q1.size()!=0 ) return q1.peek();
        else return -1;
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */