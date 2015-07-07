/*

Given a string S, find the length of the longest substring T that contains at
most two distinct characters. For example,

Given S = “eceba”,

T is "ece" which its length is 3.

*/

public class LongestSubstrWithTwoDistinctChars {
	// Use a sliding window
	// The key is when we adjust the sliding window to satisfy the invariant,
	// we need a counter of the number of times each char appears
	public int longestSubstrWithTwoDistinctChars(String s) {
		if (s == null) {
			return 0;
		}
		
		// Records how many times a character occurs
		int count[] = new int[256];
		int i = 0;
		int numDistinct = 0;
		int maxLen = 0;
		
		for (int j = 0; j < s.length(); j++) {
			if (count[s.charAt(j)] == 0) {
				numDistinct++;
			}
			count[s.charAt(j)]++;
			
			while (numDistinct > 2) {
				count[s.charAt(i)]--;			
				if (count[s.charAt(i)] == 0) {
					numDistinct--;
				}
				i++;
			}
			
			// At most 2 characterss
			maxLen = Math.max(maxLen, j - i + 1);
		}
		
		return maxLen;
	}
	
	public static void main(String[] args) {
		LongestSubstrWithTwoDistinctChars ls = new LongestSubstrWithTwoDistinctChars();
		
		String str = "abaac";
		int maxLen = ls.longestSubstrWithTwoDistinctChars(str);
		System.out.println(maxLen);
	}
}
