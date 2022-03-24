class Solution {
 public List powerfulIntegers(int x, int y, int bound) {
List res = new ArrayList<>();

    HashSet<Integer> set = new HashSet<>();
    
    for(int i = 1; i < bound ; i = i * x){
        for(int j = 1; i + j <= bound ; j = j * y){
            set.add(i + j);
            if(y == 1){break;}
        }
      if(x == 1){break;}
    }
    
    return new ArrayList<>(set);
}
}