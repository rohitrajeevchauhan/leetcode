class Solution {
    public int reversePairs(int[] nums) {
        return sortAndCount(nums, 0, nums.length - 1);
    }
    private int sortAndCount(int[] nums, int start, int end) {
        if (start >= end) return 0;
        int mid = start + (end - start) / 2;
        int count = 0;
        count += sortAndCount(nums, start, mid);
        count += sortAndCount(nums, mid + 1, end);
        count += countReversePairs(nums, start, mid, end);
        merge(nums, start, mid, end);
        return count;
    }
    private int countReversePairs(int[] nums, int start, int mid, int end) {
        int count = 0;
        int j = mid + 1;
        for (int i = start; i <= mid; i++) {
            while (j <= end && nums[i] > (long) 2 * nums[j]) {
                j++;
            }
            count += (j - (mid + 1));
        }
        return count;
    }
    private void merge(int[] nums, int start, int mid, int end) {
        int left = start, right = mid + 1, k = 0;
        long[] temp = new long[end - start + 1];
        while (left <= mid && right <= end) {
            if (nums[left] <= nums[right]) {
                temp[k++] = nums[left++];
                } else {
                    temp[k++] = nums[right++];
            }
        }
        while (left <= mid) {
            temp[k++] = nums[left++];
        }
        while (right <= end) {
            temp[k++] = nums[right++];
        }
        for (int i = 0; i < temp.length; i++) {
            nums[start + i] = (int) temp[i];
        }
}}
