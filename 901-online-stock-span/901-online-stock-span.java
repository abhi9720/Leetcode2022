class pair{
    int price;
    int day;
    public pair(int price, int day){
        this.price =  price;
        this.day =  day;        
    }
}
class StockSpanner {
    Stack<pair> stock ;
    int idx =  0;
    public StockSpanner() {
        stock =  new Stack<>();                        
    }
    
    public int next(int price) {
        while(!stock.isEmpty() && stock.peek().price <= price ){
            stock.pop();
        }
        if(stock.size()==0 ){
            stock.push(new pair(price,idx++) );
            return idx;
        }
        else{
            int day =  stock.peek().day;
            stock.push(new pair(price,idx++) );
            return stock.peek().day -  day;
        }        
    }
}

