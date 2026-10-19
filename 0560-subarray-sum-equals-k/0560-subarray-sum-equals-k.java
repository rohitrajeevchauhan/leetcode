class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer>freq=new HashMap<>();
        freq.put(0,1);
        int sum=0;
        int count=0;
        for(int num:nums){
            sum += num;
            count += freq.getOrDefault(sum-k,0);
            freq.put(sum,freq.getOrDefault(sum,0)+1);
        }
        return count
    }
}