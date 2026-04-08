class Solution {
    int ans=0;
    public int maxAreaOfIsland(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        int islands=0;
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(grid[i][j]==1)
                {
                    
                int curr=dfs(grid,i,j);
                ans=Math.max(ans,curr);
                }
            }
        }
        return ans;
        
    }
    public int dfs(int[][]grid, int rows,int cols)
    {
        if(rows<0||cols<0||rows>=grid.length||cols>=grid[0].length|| grid[rows][cols] == 0)
        return 0;

        

        grid[rows][cols]=0;
        
        return 1+dfs(grid,rows,cols+1)+
        dfs(grid,rows,cols-1)+
        dfs(grid,rows+1,cols)+
        dfs(grid,rows-1,cols);
    }
}