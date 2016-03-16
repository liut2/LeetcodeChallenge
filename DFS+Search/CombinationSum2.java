public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        //edge case
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0 || target <= 0){
            return result;
        }
        //pre-process
        Arrays.sort(nums);
        List<Integer> temp = new ArrayList<Integer>();
        boolean[] visited = new boolean[nums.length];
        //dfs
        helper(nums, target, 0, visited, temp, result);
        return result;
    }
    //dfs
    public void helper(int[] nums, int target, int pos, boolean[] visited, List<Integer> temp, List<List<Integer>> result){
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
            if (i > 0 && nums[i - 1] == nums[i] && visited[i - 1] == false){
                continue;
            }
            //cur level
            temp.add(nums[i]);
            visited[i] = true;
            //next level
            helper(nums, target - nums[i], i + 1, visited, temp, result);
            //backtrack
            temp.remove(temp.size() - 1);
            visited[i] = false;
        }
    }
}