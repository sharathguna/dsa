package code.blind75;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


public class ValidAnagram {
  public static void main(String[] args) {
    String[][] strs = {{"anagram","nagaram"},{"rat", "car"}};
    for (String[] str : strs) {
      System.out.println(isAnagram(str[0],str[1]) ? "Valid Anagram" : "Not a Valid Anagram");
    }
  }
  public static boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) return false;
    Map<Character,Integer> charMap = new HashMap<>();
    for(Character ch : s.toCharArray()) {
        charMap.put(ch, charMap.getOrDefault(ch,0) + 1);
    }
    for(Character ch : t.toCharArray()) {
      charMap.put(ch, charMap.getOrDefault(ch,0) - 1);
    }
    for (int n : charMap.values()) {
      if (n > 0) {
        return false;
      }
    }
    return true;
  }
}
