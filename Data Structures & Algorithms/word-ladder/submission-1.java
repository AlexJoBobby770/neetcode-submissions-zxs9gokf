class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set <String> set = new HashSet<>();
        Queue<String> q= new LinkedList<>();
        int count=0;
        char word[]=new char[10];
        for(String s:wordList)
        {
            set.add(s);
        }
        if(!set.contains(endWord))
        return 0;
        q.add(beginWord);
        while(!q.isEmpty())
        {
            
            
            int size =q.size();
            count++;
            for(int k=0;k<size;k++)
            {
                String curr=q.poll();
                if(curr.equals(endWord))
                {
                    return count;
                }
                
                for(int i=0;i<curr.length();i++)
                {
                word= curr.toCharArray();
                char original=word[i];
                for(char a='a';a<='z';a++)
                { 
                     if(a == original) continue;
                    word[i]=a;
                    String next = new String(word);
                    if(set.contains(next))
                    {
                        q.add(next);
                        set.remove(next);
                    }
                    
                }

                }
            }
        }
        return 0;
    }
}
