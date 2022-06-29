class Solution {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

        List<int[]> ordered = new LinkedList<>();
        // add(index , element )
        for (int[] p : people) ordered.add(p[1], p);
        

        return ordered.toArray(new int[people.length][2]);
    }
}
