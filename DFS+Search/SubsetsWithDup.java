public class SubsetsWithDup {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //edge case
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0){
            return result;
        }
        //pre-process
        boolean[] visited = new boolean[nums.length];
        List<Integer> temp = new ArrayList<Integer>();
        Arrays.sort(nums);
        //dfs
        helper(nums, visited, 0, temp, result);
        return result;
    }
    //dfs helper
    public void helper(int[] nums, boolean[] visited, int pos, List<Integer> temp, List<List<Integer>> result){
        //base case
        result.add(new ArrayList<Integer>(temp));
        if (pos == nums.length){
            return;
        }
        //cur level
        for (int i = pos; i < nums.length; i++){
            //handle exception case
            if (i > 0 && nums[i - 1] == nums[i] && visited[i - 1] == false){
                continue;
            }
            //cur level
            visited[i] = true;
            temp.add(nums[i]);
            //next level
            helper(nums, visited, i + 1, temp, result);
            //backtrack
            visited[i] = false;
            temp.remove(temp.size() - 1);
        }
    }
}