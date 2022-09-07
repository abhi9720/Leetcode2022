## MCM Pattern
​
I think the most upvoted post didn't talk about what dp[i][j] represent and what exactly does the transition function :
​
for (int k = left; k <= right; ++k)
dp[left][right] = max(dp[left][right], nums[left-1] * nums[k] * nums[right+1] + dp[left][k-1] + dp[k+1][right])**
means.
​
Or maybe it did talk about it but I miss it. But anyway here is my understand of this problem after reading countless of posts and comments :
​
First of all, dp[i][j] in here means, the maximum coins we get after we burst all the balloons between i and j in the original array.
​
For example with input [3,1,5,8] :
​
dp[0][0] means we burst ballons between [0,0], which means we only burst the first balloon in original array. So dp[0][0] is 1 * 3 * 1 = 3.
​
dp[1][1] means we burst balloons between [1][1], which means we only burst the second ballon in the original array. So dp[1][1] is 3 * 1 * 5 = 15.
​
So in the end for this problem we want to find out dp[0][ arr.length - 1 ], which is the maximum value we can get when we burst all the balloon between [0 , length -1]
​
To get that we need the transition function :
​
for (int k = left; k <= right; ++k)
dp[left][right] = max(dp[left][right], nums[left-1] * nums[k] * nums[right+1] + dp[left][k-1] + dp[k+1][right])**