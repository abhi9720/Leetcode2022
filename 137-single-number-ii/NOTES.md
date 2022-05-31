Here is some intuition to help understand this nice and concise solution:
​
First of all, consider the (set^val) as one of the following:
1. adding "val" to the "set" if "val" is not in the "set" => A^0 = A
2. removing "val" from the "set" if "val" is already in the "set" => A^A = 0
​
Assume "ones" and "twos" to be sets that are keeping track of which numbers have appeared once and twice respectively;
​
"(ones ^ A[i]) & ~twos" basically means perform the above mentioned operation if and only if A[i] is not present in the set "twos". So to write it in layman:
​
```
​
IF the set "ones" does not have A[i]
Add A[i] to the set "ones" if and only if its not there in set "twos"
ELSE
Remove it from the set "ones"
```
So, effectively anything that appears for the first time will be in the set. Anything that appears a second time will be removed. We'll see what happens when an element appears a third time (thats handled by the set "twos").
​
After this, we immediately update set "twos" as well with similar logic:
"(twos^ A[i]) & ~ones" basically means:
​