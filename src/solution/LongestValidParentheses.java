package solution;

/**
 * Created by KEKE on 2018/5/17
 *
 * Description: Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 *
 * Example 1: Input: "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()"
 *
 */
public class LongestValidParentheses {

    public int longestValidParentheses(String s) {

        if (s.length()<=1)
            return 0;
        int[] longest = new int[s.length()];
        int max = 0;
        for (int i=1;i<s.length();i++){
            if (s.charAt(i)==')'&&i-longest[i-1]-1>=0&&s.charAt(i-longest[i-1]-1)=='('){
                longest[i] = longest[i-1]+2  +  (i-longest[i-1]-2>=0?longest[i-longest[i-1]-2]:0);
            }
            max = Math.max(longest[i],max);
        }
        return max;
    }

    public static void main(String[] args){

        String s = ")()())";
        String s1 = "()(())";
        System.out.println(new LongestValidParentheses().longestValidParentheses(s));
        System.out.println(new LongestValidParentheses().longestValidParentheses(s1));
    }
}
