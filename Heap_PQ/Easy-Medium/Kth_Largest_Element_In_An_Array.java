/*
First add K numbers in the priority queue.
Traverse the rest of the array
If any number in the array greater than the top element in the queue, then remove the top element and add the number.
At last, top element of the queue is the Kth largest element in the array.

TC -> O(N)
SC -> O(N)
*/
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0; i<k; i++) {
            pq.add(nums[i]);
        }
        
        for(int i=k; i<nums.length; i++) {
            if(nums[i] > pq.peek()) {
                pq.poll();
                pq.add(nums[i]);
            }
        }
        
        return pq.peek();
    }
}
