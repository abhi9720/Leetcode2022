public class Solution {


/**
	 * Algorithm: 1. First check the given string is a jumbled/shuffled palindrome
	 * or not. 2. Next have two pointers p1 at 0 and p2 at s.length - 1 and start
	 * iterating. 3. If chars at both the pointers are same then just shrink the
	 * window (increase the p1 and decrease the p2). 4. or Else a. find the matching
	 * pair and swap the char to p2 index (increase swap count while swapping) and
	 * finally shrink the window. b. if not found just swap once with adjacent index
	 * and increase the swap count (do not shrink the window here) 5. Print the Swap
	 * Count
	 *
	 * Time Complexity: O(n) to find Palindrome + [ O(n) for two pointer iteration *
	 * O(n) for checking and swapping ] so => O(n^2) Space Complexity: O(n)
	 *
	 */

	static int countMinimumSwap(String s) {
		if(!isShuffledPalindrome(s) ) return -1;
		
		int swapCount = 0, n = s.length();
		char ch[] = s.toCharArray();
		int p1 = 0, p2 = n - 1;
		while (p1 < p2) {
			if (ch[p1] == ch[p2]) {
				p1++;
				p2--;
			} else {
				int k = p2;
				while (k > p1 && ch[k] != ch[p1]) {
					k -= 1;
				}
				if (k == p1) {
					swap(ch, p1, p1 + 1);
					swapCount++;

				} else {
					// When Matching character found swap until K reaches p2 position
					// now count swap
					while (k < p2) {
						swap(ch, k, k + 1);
						swapCount++;
						k++;
					}
					// shrink window
					p1++;
					p2--;
				}
			}
		}
		return swapCount;
	}

	static void swap(char ch[], int i, int j) {
		char temp = ch[i];
		ch[i] = ch[j];
		ch[j] = temp;
	}
	
	// check wether this string can be make palindrome 
	public static boolean isShuffledPalindrome(String s) {
		int freq[] =  new int[26];
		for(int i=0;i<s.length();i++) {
			freq[s.charAt(i)-'a']++;
		}
		int oddCount  = 0;
		for(int c : freq) if(c%2!=0) oddCount++;
		return oddCount<=1;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		System.out.println(countMinimumSwap(s));

	}


}