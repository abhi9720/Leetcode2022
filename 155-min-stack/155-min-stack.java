class MinStack {
    private Stack<Long> stk;
    private long minEle;

    public MinStack() {
        stk = new Stack<>();
        minEle = Integer.MIN_VALUE;
    }

    public void push(int val) {
        Long l = new Long(val);
        if (stk.size() == 0) {
            stk.push(l);
            minEle = val;
        } else if (l < minEle) {
            long newVal = l + (l - minEle);
            stk.push(newVal);
            minEle = val;
        } else {
            stk.push(l);
        }
    }

    public void pop() {
        if (stk.size() == 0); else if (stk.peek() < minEle) {
            long ele = stk.pop();
            minEle = minEle + (minEle - ele);
        } else {
            stk.pop();
        }
    }

    public int top() {
        if (stk.size() == 0) return -1; else {
            long peek =  stk.peek();
            if (peek < minEle) {
                return (int)minEle;
            } else return (int)peek;
        }
    }

    public int getMin() {
        if (stk.size() == 0) return -1; else return (int) minEle;
    }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
