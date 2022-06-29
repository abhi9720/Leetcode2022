/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    short mapIdToIndex[];

    public int getImportance(List<Employee> employees, int id) {
        mapIdToIndex = new short[2001];
        short idx = 0;
        for (Employee e : employees) {
            mapIdToIndex[e.id] = idx++;
        }
        boolean visit[] = new boolean[2001];
        return dfs(employees, visit, id);

        
    }

    private int dfs(List<Employee> employees, boolean visit[], int src) {
        visit[src] = true;
        int index = mapIdToIndex[src];
        int imp =  employees.get(index).importance;
        for (int sub : employees.get(index).subordinates) {
            if (!visit[sub]) {
                imp+=dfs(employees, visit, sub);
            }
        }
        return imp;
    }
}
