// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

 // } Driver Code Ends



class Solution {
public:

    bool check(vector<int>adj[],vector<int>&colo,int s)
    {
        colo[s]=1;
        queue<int>q;
        q.push(s);  
        while(!q.empty())
        {
            int cur=q.front();
            q.pop();
            
            for(int child: adj[cur])
            {
                if(!colo[child]) // if this node is not colored 
                {
                    colo[child] =  -colo[cur];// giving alternate color 
                    // if 1 then -1 or if -1 then 1
                    q.push(child);
                }
                else if(colo[child]==colo[cur] ){
                    return false;// if already colored with same color, can't be bipartite!
                }
               
            }
        }
        return true;
    }

    bool isBipartite(int V, vector<int>adj[]){
	    // Code here
	    vector<int>colo(V,0);
	    // 0  =  no color , 1 means color A, -1 means color B
	    // 1,-1 becuse so we can give alternate color 
	    int ans=false;
	    for(int i=0;i<V;i++)
	    {
	        if(!colo[i])
	        {
	            if(check(adj,colo,i)==false) return false;
	        }
	    }
	    return true;
	}

};


// { Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int V, E;
		cin >> V >> E;
		vector<int>adj[V];
		for(int i = 0; i < E; i++){
			int u, v;
			cin >> u >> v;
			adj[u].push_back(v);
			adj[v].push_back(u);
		}
		Solution obj;
		bool ans = obj.isBipartite(V, adj);    
		if(ans)cout << "1\n";
		else cout << "0\n";  
	}
	return 0;
}  // } Driver Code Ends