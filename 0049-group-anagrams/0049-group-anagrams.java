class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char key[] = strs[i].toCharArray();
            Arrays.sort(key);
            String keyString = String.valueOf(key);
            
            map.putIfAbsent(keyString, new ArrayList<>());
            map.get(keyString).add(strs[i]);
        }
        List<List<String>> ans = new ArrayList<>(map.values());
        return ans;
    }
}
