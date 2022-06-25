class Solution {

    public boolean isAlienSorted(String[] dict, String order) {
        int K = 26;
        ArrayList<Integer>[] graph = (ArrayList<Integer>[]) new ArrayList[K];
        for (int i = 0; i < K; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < dict.length - 1; i++) {
            String w1 = dict[i];
            String w2 = dict[i + 1];            

            for (int j = 0; j < w1.length(); j++) {
                if(j>=w2.length() ) return false;
                char ch1 = w1.charAt(j), ch2 = w2.charAt(j);
                if (ch1 != ch2) {
                    graph[ch1 - 'a'].add(ch2 - 'a');
                    break;
                }
            }
        }
        

        // now run dfs
        Stack<Integer> stk = new Stack<>();
        boolean v[] = new boolean[K];
        for (int i = 0; i < K; i++) {
            if (!v[i] && graph[i].size() != 0) {
                dfs(i, graph, v, stk);
            }
        }

        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        int idx = 0;
        while (!stk.isEmpty()) {
            map.put((char) (stk.pop() + 'a'), idx++);
        }

        for (int i = 0; i < order.length(); i++) {
            for (int j = i + 1; j < order.length(); j++) {
                if (map.containsKey(order.charAt(i)) && map.containsKey(order.charAt(j))) {
                    if (!(map.get(order.charAt(i)) < map.get(order.charAt(j)))) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private void dfs(int src, ArrayList<Integer>[] graph, boolean v[], Stack<Integer> stk) {
        v[src] = true;
        for (int nbr : graph[src]) {
            if (!v[nbr]) {
                dfs(nbr, graph, v, stk);
            }
        }
        stk.push(src);
    }
}
