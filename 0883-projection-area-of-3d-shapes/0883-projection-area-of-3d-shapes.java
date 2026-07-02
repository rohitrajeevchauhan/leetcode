class Solution {
    public int projectionArea(int[][] grid) {
        int xy = 0, row[] = new int[grid.length], col[] = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0)
                    xy++;
                if (grid[i][j] > row[i])
                    row[i] = grid[i][j];
                if (grid[i][j] > col[j])
                    col[j] = grid[i][j];
            }
        int total = xy;
        for (int i : row)
            total += i;
        for (int i : col)
            total += i;
        return total;
    }
}