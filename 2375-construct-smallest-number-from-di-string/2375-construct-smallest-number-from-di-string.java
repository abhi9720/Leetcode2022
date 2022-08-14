class Solution {

    public String smallestNumber(String pattern) {
        Stack<Integer> stk = new Stack<>();
        int num = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pattern.length(); i++) {
            stk.push(num);
            num++;
            if (pattern.charAt(i) == 'I') {
                while (!stk.isEmpty()) {
                    sb.append(stk.pop());
                }
            }
        }
        stk.push(num);
        while (!stk.isEmpty()) {
            sb.append(stk.pop());
        }
        
        return sb.toString();
    }
}
