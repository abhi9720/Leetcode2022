class Solution {
    public int reversePairs(int[] nums) {
        return countpair(nums,0,nums.length-1);        
    }
    private int countpair(int nums[],int i ,int j){
		int c =0;
        if(i<j){
			int mid =  (j-i)/2+i;
            int c1 =  countpair(nums,i,mid);
			int c2 =  countpair(nums,mid+1,j);
			int c3 =  mergeAndReverse(nums,i,mid,j);
			c =  c1+c2+c3;
        }
		return c;
    }
	private int mergeAndReverse(int nums[],int i ,int mid , int j){
		int p1 = i,p2 =mid+1;
		int count = 0;
		while(p1<=mid && p2<=j){
            long n1 =  nums[p1];
            long n2  =  nums[p2];
			if(n1 > 2*n2 ){
                // System.out.println(Arrays.toString(nums) );
                // System.out.println(nums[p1] +" > "+ nums[p2]+"  "+(nums[p1] > 2*nums[p2]));
                // System.out.println("-------------------------");
				count+=(mid -p1+1) ;
				p2++;
			}
			else{
				p1++;
			}
		}
		p1 = i;p2 =mid+1;
		int idx=0;
		int buffer[] =  new int[j-i+1];
		while(p1<=mid && p2<=j){
			if(nums[p1]<=nums[p2]){
				buffer[idx++] =  nums[p1++];
			}
			else{
				buffer[idx++]=  nums[p2++];				
			}
		}

		while(p1<=mid)buffer[idx++]=  nums[p1++];
		while(p2<=j) buffer[idx++] =  nums[p2++];			

		for(int itr =  i;itr<=j;itr++){
			nums[itr] = buffer[itr-i];
		}
		return count;
	}
}