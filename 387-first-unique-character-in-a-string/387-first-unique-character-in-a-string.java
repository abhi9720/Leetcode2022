class Solution {
    public int firstUniqChar(String s) {
        int i=-1,j=0;
        HashMap<Character ,Integer> freq = new HashMap<>();
        while(j<s.length()){
            if(!freq.containsKey(s.charAt(j)) ){
                freq.put(s.charAt(j),1);
            }else{
                
                freq.put(s.charAt(j),freq.getOrDefault(s.charAt(j),0)+1);                 
                
                 
                     // means this is no longer first unique
                     while(i!=-1 && i<j && freq.get(s.charAt(i))!=1 ){                         
                         i++;
                     }
                     if(i!=-1 && freq.get(s.charAt(i))!=1){
                         i=-1;
                     }
                                               
            }   
            
            if(i==-1 && freq.get(s.charAt(j))==1  ){
                i=j;
            }
            
            j++;
        }
        return i;                     
    }
}