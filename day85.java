class Solution {
    int lps(String str) {
        int n = str.length();
        int[] lps = new int[n]; // Longest Prefix Suffix array
        int length = 0; // Length of the previous longest prefix suffix
        int i = 1; // Current index in str
        
        while (i < n) {
            if (str.charAt(i) == str.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1]; // Use the previous prefix suffix length
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        
        // The last value in lps array will be the length of the longest proper prefix which is also a proper suffix
        return lps[n - 1];
    }
}
