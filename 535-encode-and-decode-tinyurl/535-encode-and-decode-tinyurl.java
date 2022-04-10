public class Codec {

    
    static String charSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    HashMap<String, String> urlToCode =  new HashMap<>();
    HashMap<String,String> codeToUrl =  new HashMap<>();
    public String encode(String longUrl) {
        if(urlToCode.containsKey(longUrl) ){
            return urlToCode.get(longUrl);
        }
        
        StringBuilder sb =  new StringBuilder( );
        String key =  "";
        do{
            for(int i=0;i<6;i++){
                int idx =  (int)Math.random()*charSet.length();
                sb.append( charSet.charAt(idx) );
            }
            
            key  =  sb.toString();
        }
        while( codeToUrl.containsKey(key) );
        urlToCode.put(longUrl,key);
        codeToUrl.put(key,longUrl);
        return key;
    }

    // Decodes a shortened URL to its original URL .
    public String decode(String shortUrl) {
        return codeToUrl.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));