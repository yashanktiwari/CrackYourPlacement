/*
Hashmap for storing the frequencies of the unique elements.
Priority Queue for storing the integers sorted on the basis of their frequency in reverse order (higher to lower).

TC -> O(N log N)
SC -> O(N)
*/

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int n : nums) {
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> {
            return o2.freq - o1.freq;
        });
        
        for(int n : map.keySet()) {
            pq.add(new Pair(n, map.get(n)));
        }
        
        int[] ans = new int[k];
        int x = 0;
        while(k-- > 0) {
            ans[x++] = pq.poll().n;
        }
        
        return ans;
    }
    
    class Pair {
        int n;
        int freq;
        public Pair(int n, int freq) {
            this.n = n;
            this.freq = freq;
        }
    }
}
