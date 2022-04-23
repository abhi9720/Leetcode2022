
class Solution {
    public int getMinSwaps(String num, int k) {
        char mod[] = num.toCharArray();
        while(k-->0){
            nextPermutation(mod);
        }
        
        char orginal[] = num.toCharArray();
        return countSwap(mod,orginal);
        
        
    }
    private int countSwap(char mod[], char orginal[]){
        int i=0,count =0 ;
        
        while(i<mod.length ){
            if(mod[i]!=orginal[i] ){
                int j  =  i;
                while( mod[j]!=orginal[i] ){
                    j++;
                }
                //now swap pair
                while(i<j){
                    swap(mod,j,j-1 );
                    count++;
                    j--;
                }
            }
            
                i++;
            
        }
        return count;
    }
    private void nextPermutation( char ch[]  ){
        // find the element such that num[i] > nums[i-1];
        int n  =  ch.length;
        int i = n-1, p1=n-1;
        while(i>0){
            if(ch[i] > ch[i-1] ){
                p1 =  i-1;
                break;
            }
            i-=1;
        }
        if(i==0){
            reverse(ch,0,n-1);
            return;
        }
        
        // now the element such that which is greater than p1 pointed element
        i =  n-1;
        while(i>p1){
            if(ch[i] > ch[p1] ){
                break;
            }
            i-=1;
        }
        
        swap(ch,p1,i);
        reverse(ch,p1+1,n-1);
        
    }
    
    private void swap(char ch[],int i, int j){
        char t =  ch[i];
        ch[i] =  ch[j];
        ch[j] =  t;
    }
    public void reverse(char ch[] , int i , int j){
        while(i<j){
            swap(ch,i,j);
            i++;j--;
        }
    }
}

