class MyHashMap {

    List<int []> bucket [];
    int size =  0;
    int bucketsize  = 0;
    public MyHashMap() {
        bucketsize  =  10000;
        bucket =  new List[bucketsize];
        for(int i=0;i<bucketsize;i++){
            bucket[i] =  new ArrayList<>();
        }                
    }
    private int getHashCode(int key){
        return key%bucketsize;
    }
    private double loadFactor(){
        return size*1.0/bucketsize;
    }
    private void rehash(){
        List<int []> temp [] =  bucket;
        bucketsize = (bucketsize*3)/2;
        bucket =  new List[bucketsize];
        for(int i=0;i<bucketsize;i++){
            bucket[i] =  new ArrayList<>();
        }         
        
        size = 0;
        for(int i=0;i<temp.length;i++){
            for(int j=0;j<temp[i].size();j++ ){
                put(temp[i].get(j)[0] , temp[i].get(j)[1]);
            }
        }
        
    }
    
    public void put(int key, int value) {
        if(loadFactor() > 0.7){
            rehash();
        }
        int index =  getHashCode(key);
        List<int []> li =  bucket[index];
        
        for(int i=0;i<li.size();i++){
            if( li.get(i)[0]==key ){
                // update value and return 
                li.get(i)[1] =  value;
                return ;
            }
        }
        
        // if key now found 
        size++;
        li.add( new int[]{key,value }  );        
    }
    
    public int get(int key) {
        
        int index =  getHashCode(key);
        List<int []> li =  bucket[index];
        for(int i=0;i<li.size();i++){
            if( li.get(i)[0]==key ){                
                return li.get(i)[1];
            }
        }
        return -1;
        
    }
    
    public void remove(int key) {
        int index =  getHashCode(key);
        List<int []> li =  bucket[index];
        for(int i=0;i<li.size();i++){
            if( li.get(i)[0]==key ){
                size--;
                li.remove(i);
                return ;
            }
        }
        
    }
}
