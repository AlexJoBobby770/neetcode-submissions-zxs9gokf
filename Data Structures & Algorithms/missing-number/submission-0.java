class Solution {
    public int missingNumber(int[] nums) {
        int totalSum = 0 , sum = 0;
        for(int i =0;i<=nums.length-1;i++){
            totalSum += nums[i];
            sum +=i+1;
        }
        return sum - totalSum;
    }
}