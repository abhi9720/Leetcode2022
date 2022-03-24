class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i=0, j =  people.length-1;
        int boat = 0;
        while(i<j){
            int personSum  =  people[i]+people[j];
            
            if(personSum<= limit){
                boat++;
                i++;
                j--;
            }else{
                boat++;
                j--;
            }
        }
        return boat+( i==j ?1:0);
    }
}