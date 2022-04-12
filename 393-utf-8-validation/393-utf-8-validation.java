class Solution {
    public boolean validUtf8(int[] data) {
        int mask[] =  {0,6,14,30};
        int nextBitMask =  2<<6;
        int i=0;
        
        while(i<data.length){
            // check what type encoding of this char
            int type =  -1;
            
                if(data[i] >>7 == 0){
                    type=1;   
                }else if(data[i]>>5==6){
                    type=2;
                }
                else if(data[i]>>4==14){
                    type=3;
                }
                else if(data[i]>>3==30){
                    type = 4;
                }
            

            
            if(type == -1) return false;// means no valid matching
            
            // now on the basis of encoding we need to check next number
            for(int loop=1;loop<type;   loop++){                
                if( i+1 == data.length) return false;
                
                if((data[++i] & nextBitMask) != nextBitMask){
                    return false;
                }  
                
            }      
            i++;
        }
        
        
        return true;
        
    }
}