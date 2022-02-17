package Queue;

public class client {

	
	
	public static void main(String[] args) throws Exception {
//		Queue q =  new Queue(3);
//		System.out.println("size : "+ q.size());
//		q.add(10);
//		q.add(20);
//		
//		System.out.println("size : "+ q.size());
//		System.out.println(q.front());
//		
//		
//		System.out.println("size : "+ q.size());
//		System.out.println(q.front());
//		q.add(30);
//		
//		System.out.println("size : "+ q.size());
//		q.display();
//		q.remove();
//		q.remove();
//		q.add(90);
//		q.display();
		
		
		dynamicQueue dq =  new dynamicQueue(3);
		dq.add(10);
		System.out.println(dq.size());
		System.out.println(dq.capacity());
		System.out.println("--------------");
		dq.add(20);
		System.out.println(dq.size());
		System.out.println(dq.capacity());
		System.out.println("--------------");
		dq.add(30);
		System.out.println(dq.size());
		System.out.println(dq.capacity());
		System.out.println("--------------");
		dq.display();
		dq.add(40);
		
		System.out.println(dq.size());
		System.out.println(dq.capacity());
		System.out.println("--------------");
		dq.display();
		
		System.out.println(dq.front());
		
		
		
	}
}
