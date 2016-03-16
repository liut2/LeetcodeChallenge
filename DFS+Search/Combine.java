public class Combine {
    public List<List<Integer>> combine(int n, int k) {
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
            result.add(new ArrayList<Integer>(temp));
            return;
        }
        //cur level
        for (int i = pos; i < n + 1; i++){
            //handle exception cases
            //cur level
            temp.add(i);
            //next level
            helper(k, n, i + 1, temp, result);
            //backtrack
            temp.remove(temp.size() - 1);
        }
    }
}