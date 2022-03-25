class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String,Integer> map = new HashMap<>();
        
        for(String web : cpdomains ){
             
                 
            int  idx =  web.indexOf(' ');
            Integer val =  Integer.valueOf(web.substring(0,idx) );
            String domain  =  web.substring(idx+1) ;
            // start traversing form back strng if dot found , then split string 
            int j =  domain.length();
            int i =  j-1;
            while(i>=-1){
                if( i==-1 ){
                    String subdomain  =  domain.substring(i+1,j);
                    map.put(subdomain , map.getOrDefault(subdomain,0) +val  );                    
                    break;
                }
                if(domain.charAt(i)=='.'){
                    String subdomain  =  domain.substring(i+1,j);
                    map.put(subdomain , map.getOrDefault(subdomain,0) +val  );                    
                }
                i--;
            }            
        }
        ArrayList<String> ans =  new ArrayList<>();
        for(String dom : map.keySet() ){
            String count_paired =   map.get(dom)+" "+dom;
            ans.add(count_paired);            
        }
        
        return ans;
    }
}