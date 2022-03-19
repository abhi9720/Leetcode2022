class Solution {
    public boolean canReorderDoubled(int[] arr) {
        // we need to check wether double for every element is present or not
        HashMap<Integer,Integer> map =  new HashMap<>();
        int n   =  arr.length;
        Arrays.sort(arr);
        
        for(int ele : arr){
            // we will now add 0 
            if(ele !=0 ) map.put(ele , map.getOrDefault(ele,0)+1 );
        }
        
        for(int ele : arr){
            if(map.containsKey(ele) && map.containsKey(2*ele) ){
                if(map.get(ele)>1 ){
                    map.put(ele , map.get(ele)-1 );
                } else {
                    map.remove(ele);
                }
                
                if(map.get(2*ele)>1 ){
                    map.put(2*ele , map.get(2*ele)-1 );
                } else {
                    map.remove(2*ele);
                }                
            }
        }
        return map.size()==0;
        
        
        
        
    }
}