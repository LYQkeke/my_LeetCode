package solution;

/**
 * Created by KEKE on 2018/5/22
 *
 *
 Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

 You have the following 3 operations permitted on a word:

 Insert a character
 Delete a character
 Replace a character

 Example 1:
 Input: word1 = "horse", word2 = "ros"
 Output: 3
 Explanation:
 horse -> rorse (replace 'h' with 'r')
 rorse -> rose (remove 'r')
 rose -> ros (remove 'e')

 Example 2:
 Input: word1 = "intention", word2 = "execution"
 Output: 5
 Explanation:
 intention -> inention (remove 't')
 inention -> enention (replace 'i' with 'e')
 enention -> exention (replace 'n' with 'x')
 exention -> exection (replace 'n' with 'c')
 exection -> execution (insert 'u')
 */
public class EditDistance {

    public int minDistance(String word1, String word2) {

        if (word1.length()==0)
            return word2.length();
        if (word2.length()==0)
            return word1.length();

        int[][] dp = new int[word2.length()+1][word1.length()+1];
        for (int i=0;i<=word1.length();i++)
            dp[0][i] = i;
        for (int i=0;i<=word2.length();i++)
            dp[i][0] = i;

        for (int i=1;i<=word2.length();i++){
            for (int j=1;j<=word1.length();j++){
                if (word1.charAt(j-1)==word2.charAt(i-1)){
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j]+1,dp[i][j-1]+1));
                }else {
                    dp[i][j] = Math.min(dp[i-1][j-1]+1,Math.min(dp[i-1][j]+1,dp[i][j-1]+1));
                }
            }
        }
        return dp[word2.length()][word1.length()];
    }

    public static void main(String[] args){

        String s1 = "horse";
        String s2 = "ros";
        String s3 = "intention";
        String s4 = "execution";
        System.out.println(new EditDistance().minDistance(s1,s2));
        System.out.println(new EditDistance().minDistance(s3,s4));
    }
}
