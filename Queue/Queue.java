package Queue;

public class Queue {

	private int data[];
	private int front;
	private int rear;
	private int size;
	private int capacity;

	public Queue() {
		intializeQueue(15);
	}

	public Queue(int capacity) {
		intializeQueue(capacity);
	}
	
	
	

	public void intializeQueue(int capacity) {
		this.data = new int[capacity];
		this.front = -1;
		this.rear = -1;
		this.size = 0;
		this.capacity = capacity;
		
		
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public int size() {
		return this.size;
	}
	
	protected int capacity() {
		return this.capacity;
	}
	
	public void display() {
		if(this.size==0) return;
		StringBuilder sb =  new StringBuilder();
		int itr  =  this.front;
		int loop =  this.size();
		while(loop-->0) {
			sb.append( data[itr]+",");
			itr =  (itr+1)%this.capacity;
		}
			System.out.println( sb );
		
	}

	public int front() throws Exception {
		if (size == 0) {
			QueueIsEmptyException();
		}
		return this.data[this.front];
	}

	public void add(int val) throws Exception {
		if (this.size == this.capacity) {
			QueueIsFullException();
		}

		if (this.size == 0)
			this.front = 0;

		this.size++;
		this.rear = (this.rear + 1) % this.capacity;
		

		this.data[this.rear] = val;
	}

	public int remove() throws Exception {
		if (this.size == 0) {
			QueueIsEmptyException();
		}

		int temp = this.data[this.front];
		this.data[this.front]=0;

		this.size--;

		this.front = (this.front + 1) % this.capacity;

		if (this.size == 0) {
			this.front = -1;
			this.rear = -1;
		}

		return temp;
	}

	private void QueueIsFullException() throws Exception {
		if (this.capacity == this.size)
			throw new Exception("Queue is Full");
	}

	private void QueueIsEmptyException() throws Exception {
		if (this.size == 0)
			throw new Exception("Queue is Empty");
	}

}
