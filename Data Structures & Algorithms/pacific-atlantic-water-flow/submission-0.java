class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        
        Queue<int[]> q= new LinkedList<>();
        int row=heights.length;
        int col=heights[0].length;
        int pac [][]= new int[row][col];
        int atl [][]= new int[row][col];
       
        for(int i=0;i<col;i++)
        {
            q.add(new int[]{0,i});
            pac[0][i]=1;
        }
        for(int i=0;i<row;i++)
        {
            q.add(new int[]{i,0});
            pac[i][0]=1;
        }
        while(!q.isEmpty())
        {
            int node[]=q.poll();
            int r=node[0];
            int c=node[1];
            int dir[][]={{1,0},{0,1},{-1,0},{0,-1}};
            for(int dirs[]:dir)
            {
                int newr=r+dirs[0];
                int newc=c+dirs[1];
                if(newr<0||newc<0|| newr>=row||newc>=col||heights[newr][newc]<heights[r][c]||pac[newr][newc]==1)
                continue;

                q.add(new int[]{newr,newc});
                pac[newr][newc]=1;
                
                
            }
        }
        for(int i=0;i<col;i++)
        {
            q.add(new int[]{row-1,i});
            atl[row-1][i]=1;

        }
        for(int i=0;i<row;i++)
        {
            q.add(new int[]{i,col-1});
            atl[i][col-1]=1;
        }
        while(!q.isEmpty())
        {
            int node[]=q.poll();
            int r=node[0];
            int c=node[1];
            int dir[][]={{1,0},{0,1},{-1,0},{0,-1}};
            for(int dirs[]:dir)
            {
                int newr=r+dirs[0];
                int newc=c+dirs[1];
                if(newr<0||newc<0|| newr>=row||newc>=col||heights[newr][newc]<heights[r][c]||atl[newr][newc]==1)
                continue;
                q.add(new int[]{newr,newc});
                atl[newr][newc]=1;
                
                
            }
        }
        for(int i=0;i<row;i++)
        {
            for (int j=0;j<col;j++)
            {
                if(pac[i][j]==1 && atl[i][j]==1)
                {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                list.add(j);
                ans.add(list);
                }
            }
        }
       
        return ans;
    }
}
