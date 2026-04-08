class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb= new StringBuilder();
        if(digits.length()==0)
        {
            return ans;
        }
        String[] map = {    
    "abc",  
    "def",  
    "ghi",  
    "jkl",  
    "mno",  
    "pqrs", 
    "tuv",  
    "wxyz"  };

        dfs(ans,digits,0,sb,map);
        return ans;
        
    }
    public void dfs( List<String> ans ,String digits,int i,StringBuilder sb,String[] map)
    {
        if(i==digits.length())
        {
            ans.add(sb.toString());
            return;
        }
        
            String s=map[digits.charAt(i)-'2'];
            for(int j=0;j<s.length();j++)
            {
            sb.append(s.charAt(j));
            dfs(ans,digits,i+1,sb,map);
            sb.deleteCharAt(sb.length()-1);
            }

        
    }
}
