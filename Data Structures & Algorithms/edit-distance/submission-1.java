class Solution {
    public int minDistance(String word1, String word2) {
        int dp[][]= new int [word1.length()+1][word2.length()+1];
        for(int rows[]:dp)
        {
            Arrays.fill(rows,-1);
        }
        int ans=dfs(word1,word2,0,0,dp);

        return ans;
    }
    public int dfs(String word1, String word2,int i,int j,int dp[][])
    {
        if(dp[i][j]!=-1)
        return dp[i][j];

        if(i==word1.length())
        return word2.length()-j;

        if(j==word2.length())
        return word1.length()-i;

        if(word1.charAt(i)!=word2.charAt(j))
        {
            return dp[i][j]=1+Math.min(dfs(word1,word2,i+1,j+1,dp),Math.min(dfs(word1,word2,i,j+1,dp),dfs(word1,word2,i+1,j,dp)));
        }

        return dp[i][j]=dfs(word1,word2,i+1,j+1,dp);
    }
}
