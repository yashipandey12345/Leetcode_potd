class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");
        
        int len1 = words1.length;
        int len2 = words2.length;
        
        // Identify the common prefix
        int commonPrefixLength = 0;
        while (commonPrefixLength < len1 && commonPrefixLength < len2 && 
               words1[commonPrefixLength].equals(words2[commonPrefixLength])) {
            commonPrefixLength++;
        }

        // Identify the common suffix
        int commonSuffixLength = 0;
        while (commonSuffixLength < len1 - commonPrefixLength && 
               commonSuffixLength < len2 - commonPrefixLength &&
               words1[len1 - 1 - commonSuffixLength].equals(words2[len2 - 1 - commonSuffixLength])) {
            commonSuffixLength++;
        }

        // Calculate the number of words in the remaining parts
        int remainingWords1 = len1 - commonPrefixLength - commonSuffixLength;
        int remainingWords2 = len2 - commonPrefixLength - commonSuffixLength;

        // Check if the remaining part of the longer sentence can accommodate the shorter one
        return remainingWords1 <= 0 || remainingWords2 <= 0 || remainingWords1 == 0 || remainingWords2 == 0;
    }
}
