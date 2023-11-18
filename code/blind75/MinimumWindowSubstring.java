package code.blind75;

import java.util.Comparator;
import java.util.TreeMap;
import java.util.stream.Collectors;


public class MinimumWindowSubstring {
  public static void main(String a[]) {
    String s = "ADOBECODEBANC";
    String t = "ABC";
    System.out.println("The Minimum Substring in "+s+" containing "+t+" is : "+minWindow("abc","ac"));
  }
  public static String minWindow(String s, String t) {
    if (t.length() > s.length()) return "";
    if (t.length() == s.length()){
      if (t.equals(s)) {
        return t;
      }
      else {
        return "";
      }
    }
    int p1 = 0;
    int p2 = p1 + t.length() - 1;
    TreeMap<String,Integer> windowMap = new TreeMap<>(Comparator.comparingInt(String::length));
    while (p2<s.length() && p1<=p2) {
      String sub = s.substring(p1,p2 + 1);
      String subString = sub;
      sub = sub.chars().sorted().distinct().mapToObj(c->String.valueOf((char)c)).collect(Collectors.joining());
      if (sub.startsWith(t)) {
        windowMap.put(subString,subString.length());
        p1++;
      }
      else {
        p2++;
      }
      while (p1<p2 && !t.contains(String.valueOf(s.charAt(p1))) ){
        p1++;
      }
    }
    if (windowMap.size() >= 1) {
      return windowMap.firstKey();
    } else {
      return "";
    }
  }
}
