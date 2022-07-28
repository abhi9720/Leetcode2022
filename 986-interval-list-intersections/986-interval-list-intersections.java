class Solution {

    public int[][] intervalIntersection(int[][] l1, int[][] l2) {
        Arrays.sort(l1, (o1, o2) -> o1[0] - o2[0]);
        Arrays.sort(l2, (o1, o2) -> o1[0] - o2[0]);
        int i = 0, j = 0;
        int n1 = l1.length;
        int n2 = l2.length;
        List<int[]> ans = new ArrayList<>();
        while (i < n1 && j < n2) {
            int s1 = l1[i][0], e1 = l1[i][1];
            int s2 = l2[j][0], e2 = l2[j][1];

            if (s2 <= e1 && s2 >= s1) {
                int s = Math.max(l1[i][0], l2[j][0]);
                int e = Math.min(l1[i][1], l2[j][1]);
                ans.add(new int[] { s, e });
            } else if (s1 <= e2 && s1 >= s2) {
                int s = Math.max(l1[i][0], l2[j][0]);
                int e = Math.min(l1[i][1], l2[j][1]);
                ans.add(new int[] { s, e });
            }

            if (e1 > e2) {
                j++;
            } else {
                i++;
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
