class Solution {
    public String simplifyPath(String path) {
        String dir[] =  path.split("/");
        // System.out.println(Arrays.toString(dir));
        // skip empty string
        int i=-1;
        Stack<String> stk =  new Stack<>();
        for(String str : dir){
            if(!str.equals("")){
                // if it is .. then move one index back
                if(str.equals("..")){
                    if(stk.size()>0){
                        stk.pop();
                    }
                }
                else if(str.equals("."));
                else{
                    stk.push(str);
                }
            } 
        }
        StringBuilder sb =  new StringBuilder();
        for(String str : stk){
            sb.append("/");
            sb.append(str);
        }
        
        return sb.length()==0?"/":sb.toString();
        
    }
}