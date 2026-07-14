import java.util.Deque;
import java.util.LinkedList;
class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] score = new int[n]; 
        score[0] = nums[0];
        Deque<Integer> deque = new LinkedList<>();
        deque.offerLast(0);
        for (int i = 1; i < n; i++) {
            if (!deque.isEmpty() && deque.peekFirst() < i - k) {
                deque.pollFirst();
            }
            score[i] = nums[i] + score[deque.peekFirst()];
            while (!deque.isEmpty() && score[deque.peekLast()] <= score[i]) {
                deque.pollLast();
            }
            deque.offerLast(i); 
        }
        return score[n - 1];
        }}
