package code.blind75;

public class DecodeWays {
  public static void main(String[] args) {
    String[] s = {"06","12","226","11106"};
    for (String str : s) {
      System.out.println("The number " + str + " can be decoded in " + numDecodings(str) + " ways.");
    }
  }
  public static int numDecodings(String s) {
    int[] dp = new int[s.length()+1];
    dp[0] = 1;
    dp[1] = s.charAt(0) == '0' ? 0 : 1 ;

    for (int i=2; i<=s.length();i++) {
      int currentDigit = Integer.valueOf(s.substring(i-1,i));
      int prevDigit = Integer.valueOf(s.substring(i-2,i-1));
      if (currentDigit == 0) {
        if (prevDigit == 1 || prevDigit == 2 ) {
          dp[i] = dp[i-2];
        }
        else {
          return 0;
        }
      } else {
        if (prevDigit == 1 || (prevDigit == 2 && currentDigit < 7)) {
          dp[i] = dp[i-1] + dp[i-2];
        } else {
          dp[i] = dp[i-1];
        }
      }
    }
    return dp[s.length()];
  }
}
