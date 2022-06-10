class Solution {

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stk = new Stack<>();
        for (int ele : asteroids) {
            if (stk.size() == 0 || !willCollide(stk.peek(), ele)) {
                stk.push(ele);
            } else {
                boolean isCollapse = false;
                while (!stk.isEmpty() && willCollide(stk.peek(), ele)) {
                    int ele1 = Math.abs(ele), ele2 = Math.abs(stk.peek());
                    if (ele1 > ele2) {
                        stk.pop();
                    } else if (ele1 == ele2) {
                        stk.pop();
                        isCollapse = true;
                        break;
                    } else {
                        isCollapse = true;
                        break;
                    }
                }
                if (!isCollapse) {
                    stk.push(ele);
                }
            }
        }
        int arr[] = new int[stk.size()];
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = stk.pop();
        }
        return arr;
    }

    boolean willCollide(int ele1, int ele2) {
        return ele1 > 0 && ele2 < 0;
    }
}
