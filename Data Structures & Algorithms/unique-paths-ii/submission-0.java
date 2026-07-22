class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length + 1][obstacleGrid[0].length + 1];
       
        if (obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 0) {
            dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1] = 1;
        }
        for (int i = obstacleGrid.length - 1; i >= 0; i--) {
            for (int j = obstacleGrid[0].length - 1; j >= 0; j--) {
                if (i == obstacleGrid.length - 1 && j ==  obstacleGrid[0].length  - 1)
                    continue;
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                } else {
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                }
            }
        }
        return dp[0][0];
    }
}