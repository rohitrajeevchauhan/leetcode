import java.util.List;

class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        int mod = 1_000_000_007;
        int[][] dpSum = new int[n][n];
        int[][] dpCount = new int[n][n];
        
        dpCount[n - 1][n - 1] = 1;
        
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (dpCount[i][j] == 0) {
                    continue;
                }
                
                int[][] dirs = {{-1, 0}, {0, -1}, {-1, -1}};
                for (int[] dir : dirs) {
                    int ni = i + dir[0];
                    int nj = j + dir[1];
                    
                    if (ni >= 0 && nj >= 0 && board.get(ni).charAt(nj) != 'X') {
                        int currentScore = (board.get(ni).charAt(nj) == 'E') ? 0 : (board.get(ni).charAt(nj) - '0');
                        int nextSum = dpSum[i][j] + currentScore;
                        
                        if (nextSum > dpSum[ni][nj]) {
                            dpSum[ni][nj] = nextSum;
                            dpCount[ni][nj] = dpCount[i][j];
                        } else if (nextSum == dpSum[ni][nj]) {
                            dpCount[ni][nj] = (dpCount[ni][nj] + dpCount[i][j]) % mod;
                        }
                    }
                }
            }
        }
        
        return new int[]{dpSum[0][0], dpCount[0][0]};
    }
}
