
class Solution {

    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for (String str : strs) {
            res.append(str.length()).append("`").append(str);
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        int i = 0; // Our main pointer tracking the current position in the encoded string

        while (i < str.length()) {
            // Find where the next delimiter '`' is starting from our current position
            int j = i;
            while (str.charAt(j) != '`') {
                j++;
            }

            int length = Integer.parseInt(str.substring(i, j));
            String currentStr = str.substring(j + 1, j + 1 + length);
            ans.add(currentStr);

            i = j + 1 + length;
        }
        return ans;
    }
}