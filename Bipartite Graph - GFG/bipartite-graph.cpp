// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

 // } Driver Code Ends



class Solution {
public:

    bool check(vector<int>adj[],vector<int>&colo,int s)
    {
        colo[s]=0;
        queue<int>q;
        q.push(s);
        while(!q.empty())
        {
            int cur=q.front();
            q.pop();
            //bool a=true;
            for(int child=0;child<adj[cur].size();child++)
            {
                if(colo[adj[cur][child]]!=-1)
                {
                    if(colo[adj[cur][child]]==colo[cur])
                    return false;
                }
                else
                {
                    if(colo[cur]==0)
                    colo[adj[cur][child]]=1;
                    else
                    colo[adj[cur][child]]=0;
                    q.push(adj[cur][child]);
                }
            }
        }
        return true;
    }
	bool isBipartite(int V, vector<int>adj[]){
	    // Code here
	    vector<int>colo(V,-1);
	    int ans=false;
	    for(int i=0;i<V;i++)
	    {
	        if(colo[i]==-1)
	        {
	            if(!check(adj,colo,i))
	            {
	                return false;
	            }
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