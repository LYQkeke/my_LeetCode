package solution;

/**
 * Created by KEKE on 2018/5/22
 *
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 *
 Input:
 [
 [1,3,1],
 [1,5,1],
 [4,2,1]
 ]
 Output: 7
 Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */
public class MinimumPathSum {

    public int minPathSum(int[][] grid) {

        if (grid.length==0||grid[0].length==0)
            return 0;
        int dp[] = grid[0];
        for (int i=1;i<grid[0].length;i++)
            dp[i] += dp[i-1];
        for (int i=1;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (j>0){
                    dp[j] = (dp[j]<dp[j-1]?dp[j]:dp[j-1]) + grid[i][j];
                }else {
                    dp[j] = dp[j] + grid[i][j];
                }
            }
        }
        return dp[dp.length-1];
    }

    public static void main(String[] args){

        int[][] testGrid = {{1,3,1},{1,5,1},{4,2,1}};
        int[][] testGrid1 = {{1,2},{5,6},{1,1}};
        System.out.println(new MinimumPathSum().minPathSum(testGrid));
        System.out.println(new MinimumPathSum().minPathSum(testGrid1));
    }
}
