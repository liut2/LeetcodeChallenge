public class FindStrobogrammatic {
    public List<String> FindStrobogrammatic(int n) {
        List<String> result = new ArrayList<String>();
        if (n <= 0){
            return result;
        }
        //pre-process
        int[] choice = {0, 1, 6, 8, 9};
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 0);
        map.put(1, 1);
        map.put(6, 9);
        map.put(8, 8);
        map.put(9, 6);
        //dfs
        helper(0, n, "", choice, result, map);
        return result;
    }

    public void helper(int pos, int n, String str, int[] choice, List<String> result, HashMap<Integer, Integer> map){
        //base case
        if (pos == n / 2){
            String left = str;
            String right = generateRight(str, map);
            if (n % 2 == 0){
                result.add(left + right);
            }else{
                int[] mids = {0, 1, 8};
                for (int i = 0; i < mids.length; i++){
                    String mid =  Integer.toString(mids[i]);
                    result.add(left + mid + right);
                }
            }
            return;
        }
        //main body
        //since there are multiple possibilities for current level, we need a for loop to try every possibility
        for (int i = 0; i < choice.length; i++){
            //this is the choice for current level
            String temp = Integer.toString(choice[i]);
            //handle exception case, since 0 can't be the start digit
            if (pos == 0 && temp.equals("0")){
                continue;
            }
            //try next level, notice we need to proceed with pos, otherwise it result in stackoverflow
            helper(pos + 1, n, str + temp, choice, result, map);
            //notice here we don't need to manually backtrack, because we used string instead of stringbuilder
            //modifying string doesn't change its original value once the recursion returns, but modification to
            //the stringbuilder will persist after recursion returns, so we need to undo that change before trying next
            //possibility. Thus, generally I prefer to use string since I don't need to manually backtrack
        }
    }
    //mirror left to generate right
    public String generateRight(String str, HashMap<Integer, Integer> map){

        StringBuilder sbRight = new StringBuilder();
        for (int i = 0; i < str.length(); i++){
            int num = str.charAt(i) - '0';
            sbRight.append(map.get(num));
        }
        String right = sbRight.reverse().toString();
        return right;
    }
}
