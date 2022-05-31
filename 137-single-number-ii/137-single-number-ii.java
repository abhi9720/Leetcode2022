// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
// https://leetcode.com/problems/maximum-number-of-consecutive-values-you-can-make/

class Solution {
    public int singleNumber(int[] nums) {
        int _3n=-1, _3np1=0,_3np2=0;
        for(int ele : nums){
            int commonWith3n = ele & _3n;
			int commonWith3np1 =  ele & _3np1;
			int commonWith3np2 =  ele & _3np2;

			// so the bits common with 3n will be off, 
			// because after adding ele to themm 
			// their count goes to _3np1 type
			_3n = _3n^commonWith3n;// off in 3n
			_3np1 = _3np1 | commonWith3n;// on in 3n+1;

			_3np1 = _3np1 ^ commonWith3np1; // off in 3np1
			_3np2 = _3np2 | commonWith3np1; // on in 3np2

			_3np2 = _3np2 ^ commonWith3np2; // off in 3np2
			_3n = _3n | commonWith3np2; // on in 3n
        }

		return _3np1;
        
        
 
    }
}