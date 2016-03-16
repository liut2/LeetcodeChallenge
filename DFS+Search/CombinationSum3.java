public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        //edge case
        List<List<Integer>> result = new ArrayList<>();
        if (k <= 0 || n <= 0){
            return result;
        }
        //pre-process
        List<Integer> temp = new ArrayList<Integer>();
        //dfs
        helper(k, n, 1, temp, result);
        return result;
    }
    //dfs
    public void helper(int k, int n, int pos, List<Integer> temp, List<List<Integer>> result){
        //base case
        if (temp.size() == k){
            if (n == 0){
                result.add(new ArrayList<Integer>(temp));
            }
            return;
        }
        //cur level
        for (int i = pos; i < 10; i++){
            //handle exception cases
            if (i > n){
                break;
            }
            //cur level
            temp.add(i);
            //next level
            helper(k, n - i, i + 1, temp, result);
            //backtrack
            temp.remove(temp.size() - 1);
        }
    }
}