1. lower limit is max of array , as atleast max present in one part still , min maximum value is maximum of array
2. higher limit till this sum can goes will be sum of array
3. now our answer also lies in this limit , as low to high is sorted array , and our answer is one of the point of this limit
4. for this point , all subarray sum will be less than this
5. FFFFFFFFFFFFFFFFTTTTTTTTTTTTTTTTTT
6. our number line looks somthing like this
7. for certain limt it will not satisfy this condition , that is for example 1 , lower value for which this condition satisfy is 18 . for 17 , 16, .......... it will be false
8. and for 18 , 19 ,20 ,21 ,22 it will be true
9. we have to return this transition point false to true , means first true point
​
​
​