class Solution {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal = new ArrayList<>();
        ArrayList<Integer> level = new ArrayList<>();
        level.add(1);
        pascal.add(level);
        for (int i = 1; i < numRows; i++) {
            level = new ArrayList<>();
            level.add(1);
            for (int j = 1; j < i; j++) {
                int val =  pascal.get(i-1).get(j-1) + pascal.get(i-1).get(j);
                level.add(val);
            }
            level.add(1);
            pascal.add(level);
        }
        return pascal;
    }
}
