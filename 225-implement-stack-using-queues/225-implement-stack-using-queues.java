class MyStack {
    Queue<Integer> q1 , q2;

    public MyStack() {
        q1 =  new ArrayDeque<>();
        q2 =  new ArrayDeque<>();        
    }
    
    public void push(int x) {
        while(!q1.isEmpty() ){
			q2.offer(q1.poll());			
		}
		q1.offer(x);
		while(!q2.isEmpty() ){
			q1.offer(q2.poll());			
		}

    }
    
    public int pop() {
		if(empty()) return -1;
        return q1.poll();
    }
    
    public int top() {
		if(empty()) return -1;
        return q1.peek();
    }
    
    public boolean empty() {
        return (q1.size() + q2.size()) == 0 ;
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