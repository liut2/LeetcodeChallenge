public class IsStrobogrammatic {
    public boolean isStrobogrammatic(String num) {
        if (num == null || num.length() == 0){
            return false;
        }
        //pre-process
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(1, 1);
        map.put(6, 9);
        map.put(9, 6);
        map.put(8, 8);
        map.put(0, 0);
        //recursion
        return helper(num, 0, num.length() - 1, map);
    }
    public boolean helper(String str, int start, int end, HashMap<Integer, Integer> map){
        //base case
        if (start > end){
            return true;
        }
        //cur level
        int s = str.charAt(start) - '0';
        int e = str.charAt(end) - '0';
        if (!map.containsKey(s) || !map.containsKey(e)){
            return false;
        }
        boolean curResult = map.get(s) == e;
        //next level
        return curResult && helper(str, start + 1, end - 1, map);
    }
}
