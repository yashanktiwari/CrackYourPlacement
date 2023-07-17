/*
Use a priotity queue (i, j, value), sorted on the basis of the values
Also use a boolean visited[][] matrix to keep a track of all the nodes that are already visited.
For every i,j stored in pq, traverse in all the four directions and put them in the queue, if they are not visited.
Every time we take out a value, decrement the value of k
When the value of k is 0, return the value.
*/
class Solution {
    public int kthSmallest(int[][] arr, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.data - o2.data;
            }
        });
        
        pq.add(new Pair(0, 0, arr[0][0]));
        boolean[][] visited = new boolean[arr.length][arr[0].length];

        int[] r = {-1, 0, 1, 0};
        int[] c = {0, -1, 0, 1};

        visited[0][0] = true;
        
        while(!pq.isEmpty()) {
            Pair rp = pq.poll();

            int i = rp.i;
            int j = rp.j;
            int data = rp.data;

            k--;

            if(k == 0) return data;
            
            for(int x=0; x<4; x++) {
                int newr = i + r[x];
                int newc = j + c[x];

                if(newr >= 0 && newc >= 0 && newr < arr.length && newc < arr[0].length && !visited[newr][newc]) {
                    pq.add(new Pair(newr, newc, arr[newr][newc]));
                    visited[newr][newc] = true;
                }
            }
        }

        return -1;
    }

    class Pair {
        int i;
        int j;
        int data;
        public Pair(int i, int j, int data) {
            this.i = i;
            this.j = j;
            this.data = data;
        }
    }
}
