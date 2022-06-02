class Solution {
    public void rotate(int[][] matrix) {
        flipMainDiagonal(matrix);
		reveseRows(matrix);
    }

	private void reveseRows(int [][]mat){
		int n =  mat.length, m =  mat[0].length;
		for(int row []: mat){
			reverse(row,0,m-1);
		}
	}
	private void reverse(int arr[],int i, int j){
		while(i<j){
			int t  =  arr[i];
			arr[i] =  arr[j];
			arr[j] =  t;
			i++;
			j--;
		}
	}
    private void flipMainDiagonal(int [][]mat){
        int n=  mat.length , m =  mat[0].length;
        for(int i=0;i<n;i++){
			for(int j=0;j<i;j++){
				int t =  mat[i][j];
				mat[i][j] =  mat[j][i];
				mat[j][i] =  t;
			}
		}        
    }
}