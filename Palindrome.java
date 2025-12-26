/** Checks if a given string is a palindrome. */
public class Palindrome {

	public static void main(String[]args) {
    	System.out.println(isPalindrome(args[0]));
    }
	
	/** Checks if the given string is a palindrome. */
	public static boolean isPalindrome(String s) {
		if (s.length() == 0 || s.length() == 1) {
			return true;
		}

		//check if the first and last letter are the same letter

		if (s.charAt(0) == s.charAt(s.length() - 1)) {
			s = s.substring(1, s.length() - 1);
		} else {
			return false;
		}

		return isPalindrome(s);


    }
}