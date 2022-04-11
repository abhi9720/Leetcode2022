class Solution {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        int SIZE = 26; // total character size
        ArrayList<Integer[]> trie = new ArrayList<>(); // we use list to mimic the trie tree
        trie.add(Collections.nCopies(SIZE, 0).toArray(new Integer[0]));
        ArrayList<Integer> count = new ArrayList<>(List.of(0)); // the number of words ending at node i
        for (String word : words) {
            // sort and remove duplicates
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            StringBuilder sb = new StringBuilder();
            sb.append(chars[0]);
            for (int i = 1; i < chars.length; i++) {
                if (chars[i] != chars[i - 1]) {
                    sb.append(chars[i]);
                }
            }
            if (sb.length() <= 7) { // longer words are never valid
                // insert into trie
                int node = 0;
                for (char letter : sb.toString().toCharArray()) {
                    int i = letter - 'a';
                    if (trie.get(node)[i] == 0) { // push empty node
                        trie.add(Collections.nCopies(SIZE, 0).toArray(new Integer[0]));
                        count.add(0);
                        trie.get(node)[i] = trie.size() - 1;
                    }
                    node = trie.get(node)[i];
                }
                count.set(node, count.get(node) + 1);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (String puzzle : puzzles) {
            result.add(dfs(0, false, puzzle, trie, count));
        }
        return result;
    }

    // search for valid words
    int dfs(int node, boolean hasFirst, String puzzle, List<Integer[]> trie, List<Integer> cnt) {
        int total = hasFirst ? cnt.get(node) : 0;
        for (char letter : puzzle.toCharArray()) {
            int i = letter - 'a';
            if (trie.get(node)[i] > 0) {
                total += dfs(trie.get(node)[i], hasFirst || (letter == puzzle.charAt(0)), puzzle, trie, cnt);
            }
        }
        return total;
    }
}