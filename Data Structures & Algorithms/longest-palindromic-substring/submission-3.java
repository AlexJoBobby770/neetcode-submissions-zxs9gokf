class Solution {
    public String longestPalindrome(String s) {
        int maxLen = 0;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = calc(i, i, s);     // odd
            int len2 = calc(i, i + 1, s); // even
            int len = Math.max(len1, len2);

            if (len > maxLen) {
                maxLen = len;
                start = i - (len - 1) / 2;
            }
        }

        return s.substring(start, start + maxLen);
    }

    int calc(int l, int r, String s) {
        while (l >= 0 && r < s.length() &&
               s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }
}