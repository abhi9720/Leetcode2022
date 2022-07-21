class Solution {

    public int[][] diagonalSort(int[][] mat) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = mat.length, m = mat[0].length;

        int i = 0, j = m - 1;
        while (i != n - 1 || j != 0) {
          // insert digonally in matrix 
            for (int x = i, y = j; x < n && y < m; x++, y++) {
                pq.offer(mat[x][y]);
            }
            // pop out and fill back in matrix 
            for (int x = i, y = j; x < n && y < m; x++, y++) {
                mat[x][y] = pq.poll();
            }
            if (j - 1 >= 0) j -= 1; else i++;
        }
        return mat;
    }
}
/*
Approach1 :  
    1. Traverse diagonal , store in list , sort the list.    
    2. loop diagonal again and fill with list element 
    // or use PriorityQueue        
*/
