class Solution {
    public int maxArea(int[] heights) {
        int left=0;
        int right=heights.length-1;
        int area=0,maxarea=0;
        while(left<right)
        {
            int w=right-left;
            int height=Math.min(heights[left],heights[right]);
            area=w*height;
            maxarea=Math.max(area,maxarea);
            if(heights[left]<heights[right])
            left++;
            else
            right--;
        }
        return maxarea;
        
    }
}
