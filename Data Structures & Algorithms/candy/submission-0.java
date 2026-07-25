class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length;
        
        if(n==1)
        return 1;
        int ans[]= new int[n];
        for(int i=0;i<n;i++)
        {
            ans[i]=1;
        }
        int result=0;

        int prev=0;
        int curr=1;
        while(curr<n)
        {
            if(ratings[curr]>ratings[prev])
            {
                ans[curr]=ans[prev]+1;
                
            }
            else if(ratings[curr]==ratings[prev])
            {
                ans[curr]=1;
            }
            else
            {
                if(ans[prev]>ans[curr])
                ans[curr]=1;
                else
                {
                ans[prev]=ans[curr]+1;
                int temp_prev=prev;
                int temp_curr=curr;
                while(temp_prev>=0)
                {
                    if( ratings[temp_prev]>ratings[temp_curr] && ans[temp_prev]<=ans[temp_curr])
                    {
                        ans[temp_prev]++;
                       
                    }
                     temp_prev--;
                        temp_curr--;
                }
                }
            }
            curr++;
            prev++;
        } 
        for(int val:ans)
        {
            result+=val;
        }  
        return result;     
    }
}