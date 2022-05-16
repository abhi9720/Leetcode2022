class Solution {
    String[] words;
    String result;
    public boolean isSolvable(String[] words, String result) {
        this.words = words;
        this.result = result;
        boolean[] used = new boolean[10];
        
        int[] map = new int[128];
        Set<Character> starts = new HashSet<>();
        Set<Character> all = new HashSet<>();
        for(String word : words) {
            int index = 0;
            for(char c : word.toCharArray()) {
                if(index == 0 && word.length()>1)
                    starts.add(c);
                index++;
                all.add(c);
            }
        }
        int index = 0;
        for(char c : result.toCharArray()) {
            if(index == 0 )
                starts.add(c);
            index++;
            all.add(c);
        }
        char[] arr = new char[all.size()];
        index = 0;
        for(char c : all)
            arr[index++] = c;
        
        return dfs(arr, starts, map, used, 0);
    }
    
    
    boolean dfs(char[] arr, Set<Character> starts, int[] map, boolean[] used, int startI) {
        if(startI == arr.length) {
            return calculate(map);
        }
        
        for(int i = 0; i < 10; i++) {
            if(used[i])
                continue;
            
            if(i == 0 && starts.contains(arr[startI]))
                continue;
            map[arr[startI]] = i;
            used[i] = true;
            if(dfs(arr, starts, map, used, startI+1))
                return true;
            used[i] = false;
            map[arr[startI]] = 0;
        }
        return false;
    }
    
    boolean calculate(int[] map) {
        int sum = 0;
        for(String word : words) {
            int num = 0;
            for(char c : word.toCharArray()) {
                num = num*10 + map[c]; 
            }
            sum += num;
        }
        
        int num = 0;
        for(char c : result.toCharArray()) {
            num = num*10 + map[c];
        }
        
        return num == sum;
    }
}