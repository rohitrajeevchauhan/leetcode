public class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int count = 0;
        for (String pattern : patterns) {
            if (word.contains(pattern)) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Solution solver = new Solution();
        String[] patterns = {"a", "abc", "bc", "d"};
        String word = "abc";
        int result = solver.numOfStrings(patterns, word);
        System.out.println("Number of matching substrings: " + result); 
    }
}
