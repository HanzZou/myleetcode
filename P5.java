/*
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example:
Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
 
Example:
Input: "cbbd"
Output: "bb"
*/
public class P5 {
    public String longestPalindrome(String s) {
        String longest = "";
        int len = s.length();
        if(len < 2)
            return s;
        int max = 0;
        for(int i = 0; i < len; i++) {
            for(int j = 0; (i-j>=0)&&(i+j<=len-1); j++) {
                if (s.charAt(i-j) != s.charAt(i+j))
                    break;
                if (2 * j + 1 > max) {
                    longest = s.substring(i-j, i+j+1);
                    max = 2 * j + 1;
                }
            }

            for(int j = 0; (i-j>=0)&&(i+j+1<=len-1); j++) {
                if (s.charAt(i-j) != s.charAt(i+j+1))
                    break;
                if (2*j+2 > max) {
                    longest = s.substring(i-j, i+j+2);
                    max = 2 * j + 2;
                }
            }
        }
        return longest;
    }
    
    public static void main(String[] args) {
        P5 solution = new P5();
        System.out.println(solution.longestPalindrome("abbcd"));
    }
}