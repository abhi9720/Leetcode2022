
public class dynamicStack extends stack {
	public dynamicStack(int size) {
		super(size);		
	}
	
	
	@Override
	public void push(int val) throws Exception {
		if(super.size()== super.capacity() ) {
			resize();
		}
		super.push(val);
		
	}
	
	public void resize() throws Exception {
		int []temp =  new int[super.capacity()];
		int idx =  super.size()-1;
		// copy array 
		while(super.size()!=0) {
			temp[idx--]=super.pop();									
		}
		
		super.intialize(this.capacity()*2);
		for(int i=0;i<temp.length;i++) {
			super.push(temp[i]);				
		}		
		
		
		
	}
	
	

}
