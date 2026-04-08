class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map <String,List<String>> set= new HashMap<>();
        
        for(String s: strs)
        {
            int count[]= new int [26];
            for(char c:s.toCharArray())
            {
                count[c-'a']++;
            }
            String key=Arrays.toString(count);
            set.putIfAbsent(key,new ArrayList<>());
            set.get(key).add(s);
        }

        return new ArrayList<>(set.values());
    }
}
