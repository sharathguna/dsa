package code.blind75;

public class ValidPalindrome {
  public static void main(String[] args) {
    String[] str = {".,","A man, a plan, a canal: Panama","race a car"," "};
    for (String s: str) {
      System.out.println("The string "+s+" is "+ (isPalindrome(s) ? "a Valid " : "an Invalid ")+" Palindrome");
    }
  }
  static boolean isPalindrome(String s) {
    if (s.isEmpty() || s.isBlank()) return true;
    if (s.length() == 1) return true;
    int left = 0;
    int right = s.length()-1;
    s = s.toLowerCase();
    while (left < right) {
      while ( left < right && !isAlphaNum(s.charAt(left))) {
        left++;
      }
      while (right > left && !isAlphaNum(s.charAt(right))) {
        right--;
      }
      if (s.charAt(left) != s.charAt(right)) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }
  static boolean isAlphaNum(char ch) {
    return ((int) ch >= 48 && (int) ch <= 57) || (((int) ch >= 97 && (int) ch <= 122));
  }
}
