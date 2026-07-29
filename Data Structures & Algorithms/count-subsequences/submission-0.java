class Solution {
    public int numDistinct(String s, String t) {
        int dp[][]= new int [s.length()+1][t.length()+1];
        for(int rows[]:dp)
        {
            Arrays.fill(rows,-1);
        }
        int ans=dfs(s,t,0,0,dp);
        return ans;

        
    }
    public int dfs(String s,String t,int i,int j,int dp[][])
    {
        if(i== s.length() )
        return 0;

        if(dp[i][j]!=-1)
        return dp[i][j];

        if(j==t.length()-1 && s.charAt(i)==t.charAt(j) )
        return 1+dfs(s,t,i+1,j,dp);



        if(j!=t.length()-1 && s.charAt(i)==t.charAt(j) )
        return dp[i][j]=dfs(s,t,i+1,j+1,dp)+dfs(s,t,i+1,j,dp);

        return dp[i][j]=dfs(s,t,i+1,j,dp);
    }
}