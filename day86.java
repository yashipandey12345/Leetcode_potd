class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        Set<String> dictSet = new HashSet<>();
        for (String word : dictionary) {
            dictSet.add(word);
        }
        
        // dp[i] represents the minimum extra characters for s[0:i]
        int[] dp = new int[n + 1];
        
        // Base case: no extra characters for the empty substring
        dp[0] = 0;
        
        for (int i = 1; i <= n; i++) {
            // Initialize dp[i] assuming the last character is extra
            dp[i] = dp[i - 1] + 1;
            
            // Check all possible substrings ending at i
            for (int j = 0; j < i; j++) {
                String substring = s.substring(j, i);
                if (dictSet.contains(substring)) {
                    dp[i] = Math.min(dp[i], dp[j]);
                }
            }
        }
        
        // The answer is the minimum extra characters for the whole string
        return dp[n];
    }
}
