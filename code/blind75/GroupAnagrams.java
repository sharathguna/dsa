package code.blind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class GroupAnagrams {
  public static void main(String[] args) {
    String[] strings = {"eat","tea","tan","ate","nat","bat"};
    System.out.println("The strings after grouping as anagrams are : ");
    List<List<String>> result = groupAnagrams(strings);
    for (List<String> list : result) {
      System.out.println(list);
    }
  }
  public static List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> result;
    Map<String, List<String>> resultMap = new HashMap<>();
    for (String word: strs) {
      char[] chars = word.toCharArray();
      Arrays.sort(chars);
      String sortedWord = new String(chars);
      List<String> tempList;
      if (resultMap.containsKey(sortedWord)) {
        tempList = new ArrayList<>(resultMap.get(sortedWord));
        tempList.add(word);
        resultMap.put(sortedWord,tempList);
      } else {
        tempList = new ArrayList<>(List.of(word));
        resultMap.put(sortedWord, tempList);
      }
    }
    result = new ArrayList<>(resultMap.values());
    return result;
  }
}
