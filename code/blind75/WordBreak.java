package code.blind75;

import java.util.ArrayList;
import java.util.List;


public class WordBreak {
  public static void main(String[] args) {
    String str = "leetcodeneetcode";
    List<String> wordDict = new ArrayList<>();
    wordDict.add("leet");
    wordDict.add("code");
    wordDict.add("neet");
    System.out.println(
        "The given string " + str + " can be segmented into space seperated strings from the given Dict : " + wordDict + " ? : " + wordBreak(str, wordDict));
  }

  public static boolean wordBreak(String s, List<String> wordDict) {
    boolean[] dp = new boolean[s.length() + 1];
    dp[s.length()] = true;
    for (int i = s.length() - 1; i >= 0; i--) {
      for (String word : wordDict) {
        if (i + word.length() <= s.length() && word.equals(s.substring(i, i + word.length()))) {
           dp[i] = dp[i + word.length()];
        } if (dp[i]) break;
      }
    }
    return dp[0];
  }
}
