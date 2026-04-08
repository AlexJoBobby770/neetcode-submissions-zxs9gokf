class Solution {
    
    public List<List<String>> solveNQueens(int n) {
        boolean cols[]= new boolean [n];
        boolean diag[]=new boolean[2*n-1];
        boolean diag2[]=new boolean[2*n-1];
        List<List<String>> ans = new ArrayList<>();
        List<String> board= new ArrayList<>();
        dfs(ans,0,n,cols,diag,diag2,board);
        return ans;
        
    }
    public void dfs(List<List<String>> ans,int i,int n,boolean cols[],boolean diag[],boolean diag2[],List<String> board)
    {
        if(i==n)
        {
            ans.add(new ArrayList(board));
            return;
        }
        
        for(int j=0;j<n;j++)
        {
            char q[]= new char[n];
            Arrays.fill(q,'.');
            
            if(cols[j]!=true && diag[i-j+n-1]!=true &&diag2[i+j]!=true)
            {
                q[j]='Q';
                board.add(new String(q));
                cols[j]=true;
                diag[i-j+n-1]=true;
                diag2[i+j]=true;
                dfs(ans,i+1,n,cols,diag,diag2,board);
                board.remove(board.size()-1);
                cols[j]=false;
                diag[i-j+n-1]=false;
                diag2[i+j]=false;
            }
        }
    }
}
