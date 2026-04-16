class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) return "";

        // Frequency map for characters in t
        int[] targetFreq = new int[128];
        for (char c : t.toCharArray()) {
            targetFreq[c]++;
        }

        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int startIdx = 0;
        int requiredChars = t.length();

        while (right < s.length()) {
            char rightChar = s.charAt(right);
            
            // If we find a character that is needed for t, decrement requiredChars
            if (targetFreq[rightChar] > 0) {
                requiredChars--;
            }
            // Decrement the frequency in our "needs" map (can go negative)
            targetFreq[rightChar]--;

            // When the window is valid (contains all chars of t)
            while (requiredChars == 0) {
                // Update minimum length and start index
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    startIdx = left;
                }

                // Try to shrink the window from the left
                char leftChar = s.charAt(left);
                targetFreq[leftChar]++;
                
                // If the character we just removed was essential for t
                if (targetFreq[leftChar] > 0) {
                    requiredChars++;
                }
                left++;
            }
            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIdx, startIdx + minLen);
    }
}