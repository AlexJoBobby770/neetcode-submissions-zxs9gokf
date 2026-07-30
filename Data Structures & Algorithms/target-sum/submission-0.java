class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int dp[][]= new int [nums.length][nums.length];
        for (int rows[]:dp)
        {
            Arrays.fill(rows,-1);
        }
        int ans= dfs(nums,target,0);
        return ans;
    }
    public int dfs(int nums[],int target,int x)
    {
        

        if(x==nums.length && target == 0)
        return 1;

        if(x==nums.length && target != 0)
        return 0;
        

        return dfs(nums,nums[x]-target,x+1)+dfs(nums,nums[x]+target,x+1);



        


    }
}