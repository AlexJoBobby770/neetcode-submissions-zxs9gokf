class Solution {
    public int orangesRotting(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        int k=0;
        int ans=0;
        Queue<int []> q= new LinkedList<>();
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(grid[i][j]==2)
                q.add(new int []{i,j});
                
                if(grid[i][j]==1)
                k++;
            }
        }
        if(k==0)
        return 0;
        while(!q.isEmpty())
        {
            int size=q.size();
            for(int i=0;i<size;i++)
            {
            int node[]=q.poll();
            int r=node[0];
            int c=node[1];
            int dir[][]={{1,0},{0,1},{-1,0},{0,-1}};
             
            for(int dirs[]:dir)
            {
                int newr=r+dirs[0];
                int newc=c+dirs[1];

                if(newr<0||newc<0||newr>=row||newc>=col||grid[newr][newc]==0||grid[newr][newc]==2)
                {
                    continue;
                }
                
                grid[newr][newc]=2;
                k--;
                q.add(new int []{newr,newc});
            }
                
           }
           ans++;
            

        }
        
        if(k!=0)
        return -1;

        return ans-1;
        
    }
}