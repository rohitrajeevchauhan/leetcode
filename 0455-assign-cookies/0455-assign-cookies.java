class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int child=0;
        int index=0;
        while(index<s.length && child<g.length){
            if(s[index]>=g[child]){
                child++;
            }
            index++;
        }
        return child;
    }
}