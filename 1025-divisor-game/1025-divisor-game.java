class Solution {
    public boolean divisorGame(int N) {
        if (N==1) return false;
        if (N==2) return true;
        for (int i=1;i<=N;i++){
            if (N%i == 0)
                return !(divisorGame(N-i));
        }
        return false;}
}