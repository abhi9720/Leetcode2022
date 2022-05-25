class pair {
    int id, time, phase;

    public pair(int id, int time, int phase) {
        this.id = id;
        this.time = time;
        this.phase = phase;
    }
    // phase 0 means start
    // phase 1 means end
}

class Solution {

    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<pair> stk = new Stack<>();
        int ans[] = new int[n];
        int lastTimeStamp = 0;
        int lastop  =  -1;
        for (String log : logs) {
            String vals[] = log.split(":");
            int id = Integer.parseInt(vals[0]);
            int time = Integer.parseInt(vals[2]);
            
            if (vals[1].equals("start")) {
                if (stk.size() > 0) {
                    // update running time of current running process
                    pair peek = stk.peek();
                    ans[peek.id] += (time - lastTimeStamp);
                }
                // update new pair
                stk.push( new pair(id,time,0) );   
                lastTimeStamp =  time;
            }else{// end 
                //process coming with termination condition 
                int timeDiff =  time -  lastTimeStamp + 1;
                pair peek = stk.pop();
                ans[peek.id] += timeDiff;
                lastTimeStamp =  time+1;
            }
            
        }

        return ans;
    }
}
