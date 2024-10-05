class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        // If s1 is longer than s2, no permutation can exist
        if (len1 > len2) return false;

        // Frequency arrays for characters a-z
        int[] countS1 = new int[26];
        int[] countWindow = new int[26];

        // Initialize the frequency count for s1 and the first window of s2
        for (int i = 0; i < len1; i++) {
            countS1[s1.charAt(i) - 'a']++;
            countWindow[s2.charAt(i) - 'a']++;
        }

        // Compare the frequency counts
        if (matches(countS1, countWindow)) return true;

        // Sliding window: Move the window one character at a time
        for (int i = len1; i < len2; i++) {
            // Add the next character in the window
            countWindow[s2.charAt(i) - 'a']++;
            // Remove the character that's sliding out of the window
            countWindow[s2.charAt(i - len1) - 'a']--;

            // Compare the frequency counts
            if (matches(countS1, countWindow)) return true;
        }

        return false;
    }

    // Helper method to compare two frequency arrays
    private boolean matches(int[] countS1, int[] countWindow) {
        for (int i = 0; i < 26; i++) {
            if (countS1[i] != countWindow[i]) {
                return false;
            }
        }
        return true;
    }
}

