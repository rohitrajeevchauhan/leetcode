class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set seen = new HashSet(), repeated = new HashSet();
        for(int i = 0; i + 9 < s.length(); i++) {
        String sequence = s.substring(i, i + 10);
        if(!seen.add(sequence)) repeated.add(sequence);
    }
    return new ArrayList(repeated);
    }
}