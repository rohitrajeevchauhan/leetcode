class Solution {
    public int[] singleNumber(int[] nums) {

        int xor = 0;

        for(int x : nums)
            xor ^= x;

        int bit = xor & -xor;

        int a = 0;
        int b = 0;

        for(int x : nums){

            if((x & bit)!=0)
                a ^= x;
            else
                b ^= x;
        }

        return new int[]{a,b};
    }
}