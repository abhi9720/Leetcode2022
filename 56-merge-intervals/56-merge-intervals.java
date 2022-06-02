class Solution {
     public int[][] merge(int[][] intervals) {
        Arrays.sort( intervals ,(o1,o2)-> o1[0] - o2[0] );
		int start  = intervals[0][0] , end =  intervals[0][1];
		ArrayList<int[]> ans = new ArrayList<>();
		for(int interval[] : intervals){
			int s =  interval[0] , e =  interval[1];
			if(s <= end){
				end =  Math.max(end , e);
			}
			else{
				ans.add(new int[]{start,end} );
				start =  s;
				end  =  e;
			}
		}
        ans.add(new int[]{start,end} );
        return   ans.toArray(new int[0][]);
    }
}