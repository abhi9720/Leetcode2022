class Solution {

    public int[] asteroidCollision(int[] asteroids) {
        int stk[] =  new int[asteroids.length];
        int i=-1;
        for (int ele : asteroids) {
            if (i==-1 || !willCollide(stk[i], ele)) {
                stk[++i] =  ele;
            } else {
                boolean isCollapse = false;
                while (i>=0 && willCollide(stk[i], ele)) {
                    int ele1 = Math.abs(ele), ele2 = Math.abs(stk[i]);
                    if (ele1 > ele2) {
                        --i;
                    } else if (ele1 == ele2) {
                        --i;
                        isCollapse = true;
                        break;
                    } else {
                        isCollapse = true;
                        break;
                    }
                }
                if (!isCollapse) {
                    stk[++i] =  ele;
                }
            }
        }
        int arr[] = new int[i+1 ];
        System.arraycopy(stk,0,arr,0,i+1);
        return arr;
    }

    boolean willCollide(int ele1, int ele2) {
        return ele1 > 0 && ele2 < 0;
    }
}
