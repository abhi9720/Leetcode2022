class Solution {

    public int[] sortByBits(int[] arr) {        
        mergeSort(arr, 0, arr.length - 1);
        return arr;
    }

    private void mergeSort(int arr[], int i, int j) {
        if (i == j) return;
        int mid = (j - i) / 2 + i;
        mergeSort(arr, i, mid);
        mergeSort(arr, mid + 1, j);
        mergeTwoSortedArray(arr, i, mid, j);
    }

    private void mergeTwoSortedArray(int arr[], int i, int mid, int j) {
        
        int sort[] =  new int[j-i+1];
        int p1 = i, p2 = mid + 1;
        
        int itr = 0;
        while (p1 <= mid && p2 <= j) {
                            
            if ( compareTo(arr[p1], arr[p2]) < 0) {                
                sort[itr++] = arr[p1++];                
            } else {
                sort[itr++] = arr[p2++];                
            }
        }
        while(p1<=mid) sort[itr++] = arr[p1++];     
        while(p2<=j) sort[itr++] = arr[p2++];
        System.arraycopy(sort,0,arr,i,sort.length);
        
    }

    public int bitCount(Integer n) {
        int bit = 0;
        while (n != 0) {
            int rsb = n & -n;
            n = n - rsb;
            bit++;
        }

        return bit;
    }

    public int compareTo(int a, int b) {
        int diff = bitCount(a) - bitCount(b);
        if(diff==0) return Integer.compare(a,b);
        else return diff;
    }
}
