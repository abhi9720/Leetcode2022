**find the position such tha num[i-1] is smaller than nums[i]** ,let p1 =  i-1
and from end find the element which is just greater than p1 index element
**we should perform these changes with minimum weight**
if we just increase slop as close as possible , we get next higher element
and now we need to arrange element from p1+1 to end iin accesnding order
**we have two choice**
- either sort - O(nlogn)
- as order is decreasing if we reverse then it will be increasing O(n)
​
​
> | Description |
| ----------- |
| ![image](https://assets.leetcode.com/users/images/f16499c9-c11e-44ed-b44e-140dd35cae49_1648990078.3700552.jpeg)      |
​
​
​
​