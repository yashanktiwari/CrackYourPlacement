/*
Use a queue to store the nodes and follow the 5 steps:
1. remove the value from the queue
2. if node is already visited, continue
3. mark it visited
4. add the node in the list
5. put all the non visited neighbours in the queue.

TC -> O(N)
SC -> O(1)
*/
class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[V];
        ArrayList<Integer> ans = new ArrayList<>();
        
        queue.add(0);

        while(!queue.isEmpty()) {
            int rv = queue.poll();

            if(visited[rv]) continue;

            visited[rv] = true;

            ans.add(rv);

            for(int n : adj.get(rv)) {
                if(!visited[n]) {
                    queue.add(n);
                }
            }
        }
        
        return ans;
    }
}
