class MinStack {
    Stack<Integer> data , min;
    public MinStack() {
        data  =  new Stack<>();
        min =  new Stack<>();
    }
    
    public void push(int val) {
        data.push(val);
		if(min.size()==0 || min.peek() >= val ){
			min.push(val);
		}
        
    }
    
    public void pop() {
        int popped =  data.pop();        
		if( popped ==  min.peek()){            
			min.pop();
		}		
        
    }
    
    public int top() {
		if(data.size()==0) return -1;
        return data.peek();
    }
    
    public int getMin() {
        if(min.size() ==0 ) return -1;
		return min.peek();
    }
}

