class Solution {
    public boolean exist(char[][] board, String word) {
        int rows =board.length;
        int col=board[0].length;
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(dfs(board,i,j,0,word,rows,col))
                return true;
            }
        }
        return false;

    }
    public boolean dfs(char board[][],int r,int c,int i,String word,int rows,int col)
    {
        if(i==word.length())
        return true;

        if(r<0||c<0||r>=rows||c>=col||board[r][c]!=word.charAt(i)||board[r][c]=='#')
        return false;

        board[r][c]='#';
        boolean res=dfs(board,r+1,c,i+1,word,rows,col)||
        dfs(board,r-1,c,i+1,word,rows,col)||
        dfs(board,r,c+1,i+1,word,rows,col)||
        dfs(board,r,c-1,i+1,word,rows,col);

        board[r][c]=word.charAt(i);

        return res;
    }
}
