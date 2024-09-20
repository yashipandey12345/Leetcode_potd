class Solution {
    public String shortestPalindrome(String s) {
        
        String revS = new StringBuilder(s).reverse().toString();
        String combined = s + "#" + revS;

        // Build the KMP table
        int[] lps = new int[combined.length()];
        for (int i = 1; i < combined.length(); i++) {
            int j = lps[i - 1];
            while (j > 0 && combined.charAt(i) != combined.charAt(j)) {
                j = lps[j - 1];
            }
            if (combined.charAt(i) == combined.charAt(j)) {
                j++;
            }
            lps[i] = j;
        }

        
        int longestPalindromicPrefixLength = lps[lps.length - 1];

        // Characters to add in front of the original string
        String toAdd = revS.substring(0, revS.length() - longestPalindromicPrefixLength);
        
       
        return toAdd + s;
    }
}
