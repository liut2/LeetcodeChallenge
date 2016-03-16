public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        //edge case
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0 || target <= 0){
            return result;
        }
        //pre-process
        Arrays.sort(nums);
        List<Integer> temp = new ArrayList<Integer>();
        //dfs
        helper(nums, target, 0, temp, result);
        return result;
    }
    //dfs
    public void helper(int[] nums, int target, int pos, List<Integer> temp, List<List<Integer>> result){
        //base case
        if (target <= 0){
            if (target == 0){
                result.add(new ArrayList<Integer>(temp));
            }
            return;
        }
        //cur level
        for (int i = pos; i < nums.length; i++){
            //handle exception cases
            if (nums[i] > target){
                break;
            }
            //cur level
            temp.add(nums[i]);
            //next level
            helper(nums, target - nums[i], i, temp, result);
            //backtrack
            temp.remove(temp.size() - 1);
        }
    }
}