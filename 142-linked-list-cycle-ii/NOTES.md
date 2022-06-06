![image](https://assets.leetcode.com/users/images/60a61f15-c896-4dc4-b0b0-4724d786a924_1646741797.8615613.png)
​
https://leetcode.com/problems/linked-list-cycle-ii/discuss/1701055/JavaC%2B%2BPython-best-explanation-ever-happen's-for-this-problem
​
​
More accurate expression
But the math part missed the case when fast cycled through the loop multiple times before meeting slow.
The math part should be:
What is the distance fast moved? What is the distance slow moved? And their relationship?
​
x1+x2
x1+n(x2+x3)+x2
x1+n(x2+x3)+x2=2(x1+x2)
Here n is an integer greater than or equal to 0.
And x2+x3 is the length of the loop.
Then we can get:
​
x1=(n-1)x2+nx3
After resetting slow, they will meet at the start of the loop.
This is because when slow moved x1, fast moved (x1+n(x2+x3)+x2)+((n-1)x2+nx3) = x1 + 2n(x2+x3)
​