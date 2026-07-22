class Solution {
     int dp[][];
    public int uniquePaths(int m, int n) {
       dp= new int[m][n];
        
        for(int rows[]:dp)
        {
            Arrays.fill(rows,-1);
        }
        dp[m-1][n-1]=1;
        
        return dfs(dp,0,0,m,n);
    }
    public int dfs(int dp[][],int row,int col,int m,int n)
    {
        if(row==m-1 && col==n-1)
        return 1;

        if(row>=m || col>=n ||row<0 ||col<0)
        return 0;

        if(dp[row][col] != -1)
        {
            return dp[row][col];
        }
        else
        {
            dp[row][col]=dfs(dp,row+1,col,m,n)+dfs(dp,row,col+1,m,n);
        }

        return dp[row][col];

        
        

        

    }
}