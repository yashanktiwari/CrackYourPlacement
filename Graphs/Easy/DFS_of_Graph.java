/*
Recursive function for DFS of graph:
Call for 0.
Mark the node visited.
Add it in the list.
Call the function for the non visited neighbours

TC -> O(N)
SC -> O(N) (Worst case -> recursion stack space)
*/
class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[V];
        dfs(adj, ans, visited, 0);
        return ans;
    }

    public void dfs(ArrayList<ArrayList<Integer>> graph, ArrayList<Integer> list, boolean[] visited, int i) {
        visited[i] = true;
        list.add(i);

        for(int n : graph.get(i)) {
            if(!visited[n]) {
                dfs(graph, list, visited, n);
            }
        }
    }
}
