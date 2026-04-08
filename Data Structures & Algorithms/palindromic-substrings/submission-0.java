class Solution {
    int count=0;
    public int countSubstrings(String s) {
        for(int i=0;i<s.length();i++)
        {
            expand(s,i,i);
            expand(s,i,i+1);
        }
        return count;
            }
            public void expand(String s, int x,int y)
            {
                while(x>=0 && y<s.length())
                {
                    if(s.charAt(x)!=s.charAt(y) )
                    {
                        return;
                    }
                    x--;
                    y++;
                     count++;
                }
               
            }
}
