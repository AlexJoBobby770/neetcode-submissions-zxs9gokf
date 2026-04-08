class Solution {
    public void solve(char[][] board) {
        int row=board.length;
        int col=board[0].length;
        Queue<int []> q= new LinkedList<>();
        for(int i=0;i<col;i++)
        {
            if(board[0][i]=='O')
            {
            board[0][i]='#';
            q.add(new int []{0,i});
            }
        }
        for(int i=0;i<row;i++)
        {
            if(board[i][0]=='O')
            {
            board[i][0]='#';
            q.add(new int []{i,0});
            }
        }
        for(int i=row-1;i>=0;i--)
        {
            if(board[i][col-1]=='O')
            {
            board[i][col-1]='#';
            q.add(new int []{i,col-1});
            }
        }
        for(int i=col-1;i>=0;i--)
        {
            if(board[row-1][i]=='O')
            {
            board[row-1][i]='#';
            q.add(new int []{row-1,i});
            }
        }

        while(!q.isEmpty())
        {
            int node[]=q.poll();
            int r=node[0];
            int c=node[1];
            board[r][c]='#';
            int dir[][]={{1,0},{0,1},{-1,0},{0,-1}};
             
            for(int dirs[]:dir)
            {
                int newr=r+dirs[0];
                int newc=c+dirs[1];
                if(newr<0||newc<0||newr>=row||newc>=col||board[newr][newc]=='X'||board[newr][newc]=='#')
                continue;

                board[newr][newc]='#';
                q.add(new int[]{newr,newc});
            }
        }
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(board[i][j]=='#')
                {
                    board[i][j]='O';
                }
                else if(board[i][j]=='O')
                {
                    board[i][j]='X';
                }
            }
        }
        
        
    }
}