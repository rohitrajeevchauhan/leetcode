class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int len = words.length;
        int count = 0;
        for (int i = 0; i < len - 1; i++) {
            String pref = words[i];
            for (int j = i + 1; j < len; j++) {
                if (isPrefixAndSuffix(pref, words[j])) {
                    count++;
                }
            }
        }
        return count;
    }
    private boolean isPrefixAndSuffix(String pref, String str) {
        return str.startsWith(pref) && str.endsWith(pref);
    }
}