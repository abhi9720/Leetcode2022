class Solution {

    private void swap(char sb[], int i, int j) {
        char ch =  sb[i];
        sb[i] =  sb[j];
        sb[j] =  ch;
    }
    private void reverse(char ch[], int i , int j){
        while(i<=j){
            char temp =  ch[i];
            ch[i] =  ch[j];
            ch[j] =  temp;
            i+=1;
            j-=1;
        }
    }

    public int nextGreaterElement(int n) {
        String nu =  ""+n;
        char num[] =  nu.toCharArray();
        int len = num.length;
        int i = len - 2;
        while (i >= 0 && num[i + 1] <= num[i]) {
            i -= 1;
        }
        int j = len - 1;
        if (i >= 0) {
            while (j >= 0 && num[i] >= num[j]) {
                j -= 1;
            }
            swap(num, i, j);            
        }
        
        else return -1;
        reverse(num,i+1,len-1);
        System.out.println(num);
        long nextNum  =  Long.parseLong( new String(num) );
        if (nextNum > Integer.MAX_VALUE) return -1;
        return (int)nextNum;

    }
}
