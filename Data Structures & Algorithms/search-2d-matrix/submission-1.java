public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows=matrix.length;
        int cols=matrix[0].length;
       int left=0;
       int right=rows*cols-1;
       while(left<=right)
       {
        int mid=(right+left)/2;
        int value=matrix[mid/cols][mid%cols];

        if(target==value)
        return true;
        else if(target<value)
        right=mid-1;
        else
        left=mid+1;

       }
       return false;
    }
}