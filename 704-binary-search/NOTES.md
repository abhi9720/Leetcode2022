for case if two mid
1. if we are compressing left boundary that means first we visit first mid if neccessary we can  also visit 2nd mid .
mid  =  i+(j-i)/2
​
2. If we are compressing right boundary , that means we first visit 2nd mid  if neccessary we can also visit 1 mid , if we are visiing first mid at first then we cannot visiit 2nd mid ever
mid =  i+(j-i+1)/2 -> oddd case gives mid and even length array gives 2nd mid
​
​
​