class Solution
{
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    public static String smallestWindow(String s, String p)
    {
         if (s.length() < p.length()) {
            return "-1";
        }
        HashMap<Character, Integer> pMap = new HashMap<>();
        for (char ch : p.toCharArray()) {
            pMap.put(ch, pMap.getOrDefault(ch, 0) + 1);
        }
        int start = 0, matched = 0, minLength = Integer.MAX_VALUE, minStart = 0;
        HashMap<Character, Integer> sMap = new HashMap<>();

        for (int end = 0; end < s.length(); end++) {
            char endChar = s.charAt(end);
            sMap.put(endChar, sMap.getOrDefault(endChar, 0) + 1);
            if (pMap.containsKey(endChar) && sMap.get(endChar).intValue() <= pMap.get(endChar).intValue()) {
                matched++;
            }
            while (matched == p.length()) {
                
                if (end - start + 1 < minLength) {
                    minLength = end - start + 1;
                    minStart = start;
                }

                char startChar = s.charAt(start);
                sMap.put(startChar, sMap.get(startChar) - 1);
                if (pMap.containsKey(startChar) && sMap.get(startChar).intValue() < pMap.get(startChar).intValue()) {
                    matched--;
                }

                start++;
            }
        }
        return minLength == Integer.MAX_VALUE ? "-1" : s.substring(minStart, minStart + minLength);
    }
}
