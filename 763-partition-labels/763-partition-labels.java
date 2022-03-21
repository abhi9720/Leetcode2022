class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans  = new ArrayList<>();
        // store last index of each element 
        int lastIndex[] = new int[26];
        for(int i=0;i<s.length();i++){
            char ch =  s.charAt(i);
            lastIndex[ch-'a'] =  i;
        }
        int range  = 0;
        int count  = 0;
        for(int i=0 ;i<s.length();i++){
            char ch = s.charAt(i);
            int last =  lastIndex[ch-'a'];
            range =  Math.max(range,last);
            if(i==range){
                ans.add(count+1);
                count=0;
            }else{
                count++;
            }
        }
        return ans;
    }
}