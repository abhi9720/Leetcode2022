class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> ans =  new ArrayList<>();
        if(p.length()>s.length()){
            return ans;
        }
            
        HashMap<Character,Integer> map =  new HashMap<>();
        int frep[] =  new int[26];
        
        for( int i=0 ;i<p.length();i++){
            frep[p.charAt(i)-'a']++;                        
        }
        
        // System.out.println(Arrays.toString(frep));
        int i=0, missing=p.length();
        for( ;i<p.length();i++){            
            map.put( s.charAt(i), map.getOrDefault( s.charAt(i) ,0 )+1 );
            if( map.get( s.charAt(i) ) <= frep[s.charAt(i)-'a'] ){
                // System.out.println("dec for "+ s.charAt(i));
                missing-=1;
            }   
            if(missing==0){
                ans.add(i - p.length()  +1);
            }
        }
        // System.out.println(map+"  "+missing+"  ..at index "+i);
        
        
        for( ;i<s.length();i++){
            // release 
            char release =  s.charAt( i - p.length() );
            map.put(release , map.get( release )-1);
            // if release char freq goes below need freq means we loss one char
            int relFre =  map.get(release);
            if( relFre < frep[release-'a'] ){
                missing+=1;
            }
            if(relFre==0){
                map.remove(release);
            }
            
            
            // acquire 
            map.put( s.charAt(i), map.getOrDefault( s.charAt(i) ,0 )+1 );
            if( map.get( s.charAt(i) ) <= frep[s.charAt(i)-'a'] ){
                missing-=1;
            }          
            
            // System.out.println(map+"  "+missing+"  at index "+i);
            if(missing==0){
                ans.add(i - p.length()  +1);

            }
            
        }
        
        
        
        return ans;
        
    }
}