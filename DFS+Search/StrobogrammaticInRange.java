public class StrobogrammaticInRange {
    public int strobogrammaticInRange(String low, String high) {
        //pre-process
        int[] count = {0};
        int[] choice = {0, 1, 6, 8, 9};
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 0);
        map.put(1, 1);
        map.put(6, 9);
        map.put(8, 8);
        map.put(9, 6);
        //dfs
        helper(0, low, high, "", choice, count, map);
        return count[0];
    }
    public void helper(int pos, String low, String high, String str, int[] choice, int[] count, HashMap<Integer, Integer> map){
        //base case
        long lowEnd = Long.parseLong(low);
        long highEnd = Long.parseLong(high);
        if (pos >=  low.length() / 2){
            String left = str;
            String right = generateRight(str, map);

            String resultStr = left + right;
            long resultLong = resultStr.equals("") ? 0 : Long.parseLong(resultStr);
            if (resultLong >= lowEnd && resultLong <= highEnd && resultLong != 0){
                count[0]++;
            }else if (resultLong > highEnd){
                return;
            }

            int[] mids = {0, 1, 8};
            for (int i = 0; i < mids.length; i++){
                String mid =  Integer.toString(mids[i]);
                String resultStr2 = left + mid + right;
                long resultLong2 = Long.parseLong(resultStr2);
                if (resultLong2 >= lowEnd && resultLong2 <= highEnd){
                    count[0]++;
                }else if (resultLong2 > highEnd){
                    return;
                }
            }
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
            helper(pos + 1, low, high, str + temp, choice, count, map);
            //notice here we don't need to manually backtrack, because we used string instead of stringbuilder
            //modifying string doesn't change its original value once the recursion returns, but modification to
            //the stringbuilder will persist after recursion returns, so we need to undo that change before trying next
            //possibility
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
