class SnapshotArray {
    HashMap<Integer,HashMap<Integer,Integer>> snapShot;
    HashMap<Integer,Integer> screen;
    int idx;
    public SnapshotArray(int length) {
        snapShot =  new HashMap<>();
        screen   =  new HashMap<>();
        this.idx =  0;
    }
    
    public void set(int index, int val) {
        screen.put(index,val);
    }
    
    public int snap() {
        HashMap<Integer,Integer>snap  =  new HashMap<>();
        snap.putAll(screen);
        snapShot.put(idx , snap );
        // System.out.println(snapShot);
        idx+=1;     
        return idx-1;
    }
    
    public int get(int index, int snap_id) {
        // System.out.println("snap_id "+snap_id+" index : "+index+" and map : "+snapShot);
        if(snap_id==idx){
            return screen.get(index);
        }
        else{
            return snapShot.get(snap_id).getOrDefault(index,0);   
        }
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */