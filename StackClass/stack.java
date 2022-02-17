
public class stack {
	
	private int arr[];
	private int sizeOfStack=0;
	private int sizeOfArray=0;
	private int tos=-1;
	
	public stack() {
		intialize(5);		
	}
	
	public stack(int size) {
		intialize(size);		
	}
	public void intialize(int size) {
		this.arr  =  new int[size];
		this.sizeOfArray =  size;
		this.sizeOfStack=0;
		this.tos=-1;
	}
	
	public int size() {
		return this.sizeOfStack;
	}
	public boolean isEmpty() {
		return this.sizeOfStack==0;
	}
	protected int capacity() {
		return this.sizeOfArray;
	}
	
	public void push(int val) throws Exception{
		if(sizeOfStack==sizeOfArray) {
			 throw new Exception("stackIsFull");
		}
		
		arr[++this.tos] =  val;
		this.sizeOfStack+=1;
		
	}
	public int pop() throws Exception {
		if(this.sizeOfStack==0) {
			throw new Exception("stackIsEmpty");
		}
		
		int popped =  arr[tos];
		this.arr[tos]=0;
		this.sizeOfStack-=1;
		this.tos-=1;
		return popped;
	}
	
	public int top() throws Exception {
		if(this.sizeOfStack==0) {
			throw new Exception("stackIsEmpty");
		}
		return arr[tos];
	}
	
	

}
