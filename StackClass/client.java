public class client {
	
	public static void main(String[] args) throws Exception {
		stack  stk =  new stack(5);
		stk.push(10);
		stk.push(20);
		System.out.println(stk.top());
		System.out.println(stk.isEmpty());
		System.out.println(stk.size());			
	}

}
