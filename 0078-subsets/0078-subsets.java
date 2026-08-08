class Solution {
    private void subsets(int i, List<Integer> li, List<List<Integer>> list, int[] nums) {
        if (i == nums.length) {
            list.add(new ArrayList<>(li));
            return;
        }
        li.add(nums[i]);
        subsets(i + 1, li, list, nums);
        li.remove(li.size() - 1);
        subsets(i + 1, li, list, nums);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        subsets(0, new ArrayList<>(), list, nums);
        return list;
    }}