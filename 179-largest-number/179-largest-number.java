class Solution {

    public String largestNumber(int[] nums) {
        
        mergeSort(nums, 0, nums.length - 1);
        StringBuilder sb = new StringBuilder();
        for (int ele : nums) {
            if(sb.length()==0 && ele==0 ) continue;
            sb.append(ele);
        }
        if(sb.length()==0 ) return "0";
        return sb.toString();
    }

    public static void mergeSort(int nums[], int i, int j) {
        if (i >= j) return;
        int mid = i + (j - i) / 2;
        mergeSort(nums, i, mid);
        mergeSort(nums, mid + 1, j);
        mergerTwoSorted(nums, i, j, mid);
        
    }

    private static void mergerTwoSorted(int nums[], int i, int j, int mid) {
        int temp[] = new int[j - i + 1];
        // System.out.println(i + "  " + j + "  " + mid);
        int idx = 0;
        int itr1 = i, itr2 = mid+1;
        while (itr1 <= mid && itr2 <=j) {
            int v = isGreater(nums[itr1], nums[itr2]);
            // System.out.println("Compare  => "+nums[itr1] + " " + nums[itr2] + "  " + v);
            if (v >= 0) {
                temp[idx++] = nums[itr1++];
            } else {
                temp[idx++] = nums[itr2++];
            }
        }
        while (itr1 <= mid) {
            temp[idx++] = nums[itr1++];
        }
        while (itr2 <= j) {
            temp[idx++] = nums[itr2++];
        }
        for (int x = 0; x < temp.length; x++) {
            nums[i + x] = temp[x];
        }
    }

    private static int isGreater(int a, int b) {
        String x = a + "" + b;
        String y = b + "" + a;

        return (x + y).compareTo((y + x));
    }
}
