class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max=0;
        char arr[]= new char[s.length()];
        Set<Character> map= new HashSet<>();
        arr=s.toCharArray();
        int ans=0;
        int left=0;
        int right=0;
        if(s.length()==0)
        return 0;
        else if (s.length()==1)
        return 1;
        
        while(right<s.length())
        {
           
            if(!map.contains(arr[right]))
            {
                map.add(arr[right]);
                max=right-left+1;
                right++;
            }
            else
            {
                map.remove(arr[left]);
                left++;
                max--;
            }
            ans=Math.max(ans,max);
        }
        return ans;
    }
}
