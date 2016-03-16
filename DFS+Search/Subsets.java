public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        //edge case
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0){
            return result;
        }
        //pre-process
        Arrays.sort(nums);
        List<Integer> temp = new ArrayList<Integer>();
        helper(nums, 0, temp, result);
        return result;
    }
    //dfs helper
    public void helper(int[] nums, int pos, List<Integer> temp, List<List<Integer>> result){
        //base case
        result.add(new ArrayList<Integer>(temp));
        if (pos == nums.length){
            return;
        }
        //cur level
        for (int i = pos; i < nums.length; i++){
            temp.add(nums[i]);
            //next level
            helper(nums, i + 1, temp, result);
            //backtrack
            temp.remove(temp.size() - 1);
        }
    }
}