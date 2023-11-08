package code.blind75;

import java.util.Stack;


public class ValidParentheses {
  public static void main(String[] args) {
    String str = "]";
    System.out.println("The Parentheses in the string are " + (isValid(str) ? "Valid" : "Invalid"));
  }
  public static boolean isValid(String s) {
    char[] chars = s.toCharArray();
    Stack<Character> stack = new Stack<>();
    for (char ch: chars) {
      if (ch == '(' || ch == '[' || ch == '{' ) {
        stack.push(ch);
      } else {
        if (stack.isEmpty()) return false;
        char top = stack.pop();
        switch (ch) {
          case ')' :
            if (top != '(') return false;
            break;

          case ']' :
            if (top != '[') return false;
            break;

          case '}' :
            if (top != '{') return false;
            break;
        }
      }
    }
    return stack.isEmpty();
  }
}
