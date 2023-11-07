package code.arrays;

import java.util.List;


public class LongestPalindromeSubstring {
  public static void main(String[] args) {
    String str1 = "ababa";
    String str2 = "treracecarlkp";
    String str3 = "labbap";
    List<String> inputList = List.of(str1, str2, str3);
    for (String str: inputList) {
      System.out.println("The longest palindrome of " + str + " is ---> " + longestPalindrome(str));
    }
  }
  static public String longestPalindrome(String s) {
    if (s.length() == 1) return s;
    int start = 0;
    int end = 0;

    for(int i = 0; i < s.length(); i++) {
      int len1 = expandFromMiddle(s,i,i);
      int len2 = expandFromMiddle(s,i,i+1);
      int len = Math.max(len1, len2);

      if (len > (end - start)) {
        start = i -(( len-1 ) / 2);
        end = i + (len / 2 );
      }
    }

    return s.substring(start, end + 1);
  }

  private static int expandFromMiddle(String s, int left, int right) {
    if (left > right) return 0;
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
      left--;
      right++;
    }
    return (right - left) - 1;
  }
}
