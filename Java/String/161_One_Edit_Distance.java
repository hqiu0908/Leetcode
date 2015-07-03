/*

Given two strings S and T, determine if they are both one edit distance apart.

Hint: 

1. If | n – m | is greater than 1, we know immediately both are not one- edit
distance apart.

2. It might help if you consider these cases separately, m == n and m ≠ n.

3. Assume that m is always ≤ n, which greatly simplifies the conditional
statements. If m > n, we could just simply swap S and T.

4. If m == n, it becomes finding if there is exactly one modified operation. If
m ≠ n, you do not have to consider the delete operation. Just consider the
insert operation in T.

*/

public class OneEditDistance {
	public boolean isOneEditDistance(String s, String t) {
		if (s == null || t == null) {
			return false;
		}
		
		if (s.length() > t.length()) {
			return isOneEditDistance(t, s);
		}
		
		int shift = t.length() - s.length();
		if (shift > 1) {
			return false;
		}
		
		int i = 0;
		
		// Compare the first part until meet a difference
		while (i < s.length() && s.charAt(i) == t.charAt(i)) {
			i++;
		}

		// If two strings are the same, return false
		// Check 'Append' operation
		if (i == s.length()) {
			return (shift > 0);
		}
		
		// Note!!: Jump the current inequal char if two strings 
		// have the same length.
		if (shift == 0) {
			i++;
		}
		
		// Compare the second part
		// Check 'Modify' operation (shift == 0)
		// Check 'Insert' operation (shift == 1)
		while (i < s.length() && s.charAt(i) == t.charAt(i + shift)) {
			i++;
		}
		
		return (i == s.length());
	}
	
	public static void main(String[] args) {
		OneEditDistance oneEdit = new OneEditDistance();
		
		// Modify
		String s = "abcde";
		String t = "abxde";
		System.out.println(oneEdit.isOneEditDistance(s, t));
		
		// Insert
		s = "abcxde";
		t = "abcde";
		System.out.println(oneEdit.isOneEditDistance(s, t));
		
		// Append
		s = "abcde";
		t = "abcdex";
		System.out.println(oneEdit.isOneEditDistance(s, t));
			
		s = "a";
		t = "";
		System.out.println(oneEdit.isOneEditDistance(s, t));
		
		// Wrong case:
		
		// Same string
		s = "abcde";
		t = "abcde";
		System.out.println(oneEdit.isOneEditDistance(s, t));
		
		s = "";
		t = "";
		System.out.println(oneEdit.isOneEditDistance(s, t));
		
		// Two different chars
		s = "abcde";
		t = "abcxx";
		System.out.println(oneEdit.isOneEditDistance(s, t));
	}
}

