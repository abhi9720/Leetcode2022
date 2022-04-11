class Solution {
    class pair{
        char ele;
        int freq ;
        public pair(char ele , int freq){
            this.ele =  ele;
            this.freq =  freq;
        }        
    }
    public String reorganizeString(String s) {
        PriorityQueue<pair> pq =  new PriorityQueue<>( (a,b)->{
            return b.freq -  a.freq;
        } );
        int freq[] =  new int[26];
        for(char ch : s.toCharArray() ){
            freq[ch-'a']++;
        }
        // now store in pq 
        for(int i=0;i<26;i++){
            if(freq[i]!=0 ){
                char ch  =  (char)('a'+i);
                pq.add(new pair(ch , freq[i]) );                
            }
        }
        // now start making string 
        StringBuilder sb = new StringBuilder();
        pair prev =  null;
        while(!pq.isEmpty() ){
            pair p =  pq.remove();
            sb.append( p.ele );
            p.freq -=1;
            
            if(prev!=null && prev.freq!=0){
                pq.offer(prev);
            }            
            prev = p;
        }        
        if(prev!=null && prev.freq!=0 ) return "";
        return sb.toString();                    
    }
}