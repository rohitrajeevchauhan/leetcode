import java.util.*;

class Solution {
    public int minScore(int n, int[][] roads) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            graph.get(road[0]).add(new int[]{road[1], road[2]});
            graph.get(road[1]).add(new int[]{road[0], road[2]});
        }
        
        int minScore = Integer.MAX_VALUE;
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        
        queue.offer(1);
        visited[1] = true;
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int[] neighbor : graph.get(node)) {
                int nextNode = neighbor[0];
                int distance = neighbor[1];
                minScore = Math.min(minScore, distance);
                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    queue.offer(nextNode);
                }
            }
        }
        return minScore;
    }
}