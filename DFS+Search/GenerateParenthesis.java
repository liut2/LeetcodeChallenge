public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        //edge case
        List<String> result = new ArrayList<String>();
        if (n <= 0){
            return result;
        }
        //pre-process
        int[] count = new int[2];
        HashMap<Integer, Character> map = new HashMap<Integer, Character>();
        map.put(0, '(');
        map.put(1, ')');
        dfsHelper(n, map, count, "", result);
        return result;
    }
    //dfsHelper
    public void dfsHelper(int n, HashMap<Integer, Character> map, int[] count, String temp, List<String> result){
        //base case
        if (count[0] == n && count[1] == n){
            result.add(temp);
            return;
        }
        //main body
        //cur level
        for (int i = 0; i < 2; i++){
            char ch = map.get(i);
            //handle exception cases
            if (ch == '(' && count[0] + 1 > n){
                continue;
            }
            if (ch == ')' && count[1] + 1 > count[0]){
                continue;
            }
            count[i]++;
            //next level
            dfsHelper(n, map, count, temp + ch, result);
            count[i]--;
        }
    }
}