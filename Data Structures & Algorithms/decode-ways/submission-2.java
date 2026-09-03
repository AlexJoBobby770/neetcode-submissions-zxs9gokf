class Solution {
    
    public int numDecodings(String s) {
        int ans=0;
        char arr[] = s.toCharArray();
        int dp[] = new int[arr.length];
        Arrays.fill(dp,-1);
        return dfs(arr, 0,dp);
    }

    int dfs(char arr[], int i,int dp[]) {
        if (i == arr.length)
    return 1;
        if(dp[i]!=-1)
        return dp[i];

        
        if (arr[i] == '0')
    return 0;
    int ans=0;
    
        if (arr[i] >= '1' && arr[i] <= '9') {
            dp[i]= dfs(arr, i + 1,dp);
            if ((i <= arr.length - 2 && arr[i] == '1')
                || (i <= arr.length - 2 && arr[i + 1] <= '6' && arr[i] == '2')) {
                dp[i]+= dfs(arr, i + 2,dp);
            }
        }
        return dp[i];
    }
}
