
class pair implements Comparable<pair> {
    String s;
    int count;    
    public pair(String s,int count) {
        this.s =  s;
        this.count =  count;
    }
    public int compareTo( pair o ){
        if(o.count==this.count){
            return this.s.compareTo(o.s);
        }else{
            return o.count  -  this.count;
        }
    }
}
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map = new HashMap<>();
        for(String str : words ){
            map.putIfAbsent(str,0);
            map.put(str,map.get(str)+1 );
        }
        PriorityQueue<pair> pq =  new PriorityQueue<>( 
            (o1,o2)-> o2.count -  o1.count
        );
        for(String key : map.keySet() ){
            pq.add(new pair( key , map.get(key) ) );            
        }
        map.clear();
        List<pair> ans =  new ArrayList<>();
        int loop = k;
        pair peek = null ;
        while(loop-->0 || ( pq.size()>0 && (peek.count == pq.peek().count) ) ){
            ans.add( pq.peek() );
            peek =  pq.remove();
        }
        pq.clear();
        Collections.sort(ans);
        
        List<String> res =  new ArrayList<>();
        loop = k;
        for(pair p : ans){
            res.add(p.s);
            k--;
            if(k==0) break;
        }
        ans.clear();
        
        
        return res;
        
    }
}