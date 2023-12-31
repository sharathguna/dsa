package code.blind75;

import java.util.HashMap;
import java.util.Map;


public class LongestSubstringWithoutRepeatingCharacters {
  public static void main(String[] args) {
    String str = "abba";
    System.out.println("The length of the longest substring without repeating characters is : "+ lengthOfLongestSubstring(str));
  }

  static public int lengthOfLongestSubstring(String s) {
    if (s.isEmpty()) return 0;
    int longest = 1;
    int startIndex = 0;
    Map<Character,Integer> characterSet = new HashMap<>();
    for(int i=0; i<s.length(); i++) {
      if (characterSet.containsKey(s.charAt(i))) {
        startIndex = Math.max(startIndex,characterSet.get(s.charAt(i)) + 1);
      }
      characterSet.put(s.charAt(i),i);
      if ( ( i + 1 ) - startIndex > longest ) {
        longest = ( i + 1 ) - startIndex;
      }
    }
    return longest;
  }
}
