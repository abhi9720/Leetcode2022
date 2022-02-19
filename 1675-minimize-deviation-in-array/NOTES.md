**deviation** - difference between   maximum and minimum value of array.
if we sort the array , then we want our data as much as closer to each other
e.g  [4,1,5,20,3] -> [4,2,5,5,3], now these data points are more closer to each and thus deviation is minimum possible following condition given in questions.
​
​

**Key observation :-**
* even number can be divided multiple times
* odd number can be only increase one times  then it become even number
​
if we set all number to even then we get **max limit of our data**(array).
​
now, **let we take diff between max and min value of data set**.
if **max value is even** that means we can decrease it ,
it is quite obvious that decreasing even max value will give less deviation then previous one.
* we repeat this till max element of data set is even , now this time diff between max and min value give less deviation.

** (simple word ,  intution is  increase smaller  values and decrease larger value such that these data points(element of array) are more closer to each other following condition given in question )
​


**Why i told we need to run loop till max value is even ?**
* first point we insert all value as even it implies all values is in their maximum possible value .
*  if even then it can only decrease so we keep them same while inserting.
*  if odd then we double them ,
*  **so each value in their maximum possible value and stored in sorted fashion .**
​
now if last value of **Sorted set** is odd that means we cannot decrease it further more((it can only be increase by multiply by 2)).
so  this time whatever we differnce between max and min value is minimum deviation.
​
​
​
​
​
