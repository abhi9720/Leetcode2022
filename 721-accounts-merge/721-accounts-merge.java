class Solution {
    int parent[], rank[];

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        HashMap<String, Integer> grpEmail = new HashMap<>();
        // we are here doing union of grp of email id belong to user, not the union of email id
        // like for example ,0th index grp parent is 1st index as there is one common email id
        
        for (int idx = 0;idx<n;idx++) {
            // String user = acc.get(0);
            List<String> acc =  accounts.get(idx);
            for (int i = 1; i < acc.size(); i++) {
                String email = acc.get(i);
                if (!grpEmail.containsKey(email)) {
                    grpEmail.put(email, idx);
                } else {
                    // we have seen this email id means it can combine with other email
                    
                    union(find(idx), find(grpEmail.get(email)));
                }
            }
            
        }

        List<List<String>> ans = new ArrayList<>();
        Map<Integer, ArrayList<String>> clubEmail = new HashMap<>();
        
        // club similar emails grouped in samegr[]
        for (String email : grpEmail.keySet()) {
            int grpIndex = grpEmail.get(email);
            int setlead = find(grpIndex);
            clubEmail.putIfAbsent(setlead, new ArrayList<>());
            clubEmail.get(setlead).add(email);
        }

        // sort and add user at 0th index
        for (int grpIndex : clubEmail.keySet()) {
            ArrayList<String> emails = clubEmail.get(grpIndex);
            Collections.sort(emails);
            emails.add(0, accounts.get(grpIndex).get(0));
            ans.add(emails);
        }

        return ans;
    }

    private int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private void union(int s1, int s2) {
        
        
        if (rank[s1] < rank[s2]) {
            parent[s1] = s2;
        } else if (rank[s2] < rank[s1]) {
            parent[s2] = s1;
        } else {
            parent[s1] = s2;
            rank[s2]++;
        }
    }
}
