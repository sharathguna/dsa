package code.blind75;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


public class MinimumWindowSubstring {
  public static void main(String[] a) {
    String s = "ADOBECODEBANC";
    String t = "ABC";
    System.out.println("The Minimum Substring in "+s+" containing "+t+" is : "+minWindow(s,t));
  }
  public static String minWindow(String s, String t) {
    if (s == null || t == null || t.isEmpty() || s.isEmpty()) return "";
    Map<Character,Integer> map = new HashMap<>();
    int left = 0, right = 0, min = s.length();
    int i = 0, j = 0;
    boolean found = false;
    for (char ch : t.toCharArray()) {
      map.put(ch, map.getOrDefault(ch, 0) + 1);
    }
    int count = map.size();
    while (j < s.length()) {
      char endChar = s.charAt(j++);
      if (map.containsKey(endChar)) {
        map.put(endChar, map.get(endChar) -1);
        if (map.get(endChar) == 0) {
          count -= 1;
        }
      }
      if (count > 0) continue;

      while (count == 0) {
        char startChar = s.charAt(i++);
        if (map.containsKey(startChar)) {
          map.put(startChar, map.get(startChar) + 1);
          if (map.get(startChar) > 0) {
            count = count + 1;
          }
        }
      }

      if (j-i < min) {
        left = i;
        right = j;
        min = j - i;
        found = true;
      }
    }
    return  (found) ? s.substring(left-1,right) : "";
  }
}
//    if (t.length() > s.length()) return "";
//    if (t.length() == s.length()){
//      if (stringContainsThisString(s,t)) {
//        return s;
//      }
//      else {
//        return "";
//      }
//    }
//    int p1 = 0;
//    int p2 = p1 + t.length() - 1;
//    TreeMap<String,Integer> windowMap = new TreeMap<>(Comparator.comparingInt(String::length));
//    while (p2<s.length() && p1<=p2) {
//      String subString = s.substring(p1,p2 + 1);
//      if (stringContainsThisString(subString,t)) {
//        windowMap.put(subString,subString.length());
//        p1++;
//      }
//      else {
//        p2++;
//      }
//      while (p1<p2 && !t.contains(String.valueOf(s.charAt(p1))) ){
//        p1++;
//      }
//    }
//    if (windowMap.size() >= 1) {
//      return windowMap.firstKey();
//    } else {
//      return "";
//    }
//  }
//
//  private static boolean stringContainsThisString(String subString, String t) {
//    Map<Character,Integer> charFreqMap = new HashMap<>();
//    char[] chars = t.toCharArray();
//    for(char ch : chars) {
//      if (charFreqMap.containsKey(ch)) {
//        charFreqMap.put(ch,charFreqMap.get(ch) + 1);
//      } else {
//        charFreqMap.put(ch, 1);
//      }
//    }
//    for(char ch : subString.toCharArray()) {
//      if (charFreqMap.containsKey(ch)) {
//        charFreqMap.put(ch, charFreqMap.get(ch) - 1);
//      }
//    }
//
//    for (Integer count : charFreqMap.values()) {
//      if (count > 0) {
//        return false;
//      }
//    }
//    return true;
//  }
//}
