package solution;


/**
 * Created by KEKE on 2018/5/22
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 */
public class UniquePaths2 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        if (obstacleGrid.length==0 || obstacleGrid[0].length==0)
            return 0;
        int[] dp = new int[obstacleGrid[0].length];
        dp[0] = 1;

        for (int i=0;i<obstacleGrid.length;i++){
            for (int j=0;j<obstacleGrid[0].length;j++){
                if (obstacleGrid[i][j]==1) {
                    dp[j] = 0;
                    continue;
                }
                else {
                    if (j>0)
                        dp[j] = dp[j] + dp[j-1];
                }
            }
        }
        return dp[dp.length-1];
    }

    public static void main(String[] args){

        int[][] a = {{0,0,0},{0,1,0},{0,0,0}};
        int[][] b = {{0,0},{1,1},{0,0}};
        System.out.println(new UniquePaths2().uniquePathsWithObstacles(a));
        System.out.println(new UniquePaths2().uniquePathsWithObstacles(b));
    }
}
