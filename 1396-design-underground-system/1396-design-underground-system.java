class customerData{
    int t;
    String st;
    public customerData(int t , String st){
        this.t =  t;
        this.st =  st;
    }
    public String toString(){
        return "["+t+"@"+st+"], ";
    }
}
class avgObject{
    double avg;
    int c;
    
    public String toString(){
        return "["+avg+"@"+c+"], ";
    }
    public avgObject(int c, double time){
        this.c =  c;
        this.avg  =  time;
    }
    void updateAvg(double newavg){
        
        this.avg =  newavg;
        this.c+=1;
        // System.out.println("avg updated : "+ avg );
    }    
}
class UndergroundSystem {

    
    final HashMap<Integer,customerData> train ;
    final Map<String,HashMap<String,avgObject >> record ;
    
    public UndergroundSystem() {
        train =  new HashMap<>();
        record =  new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
      
        customerData newcust =  new customerData(t,stationName);
        train.put(id,newcust);
        
        // System.out.println("check in : "+stationName);
        // System.out.println("train : "+train);
        
    }
    
    public void checkOut(int id, String stationName, int t) {
        customerData cust =  train.get(id);
        String startStation =  cust.st;
        int duration =  t - cust.t;
        record.putIfAbsent(startStation,new HashMap<>());
        HashMap<String,avgObject > endstation = record.get(startStation);
        if(endstation.containsKey(stationName) ){
            avgObject e = endstation.get(stationName);
            double newavg =  ((e.avg*e.c ) + duration)/(e.c+1);
            e.updateAvg(newavg);
        }
        else{
            avgObject entry =  new avgObject(1,duration);
            endstation.put(stationName,entry);
            
        }
        train.remove(id);
     
        //  System.out.println("check out : "+stationName);
        // System.out.println("record : "+record);
        // System.out.println("endstation : "+endstation);
        // System.out.println("-----------------------------------------");
        
    }
    
    public double getAverageTime(String startStation, String endStation) {
        if(record.containsKey(startStation) ){
            if(record.get(startStation).containsKey(endStation)){
                // System.out.println(record.get(startStation).get(endStation).c);
                return record.get(startStation).get(endStation).avg;
            }
        }
        return 0;
    }
    
    
    
    
}

