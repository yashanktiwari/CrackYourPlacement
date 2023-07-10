/*
Use DNF algorithm.
Maintain three variables si, mid and ei.
Conditions:
if(nums[mid] == 2) swap(mid, ei); ei--;
if(nums[mid] == 1) mid++;
if(nums[mid] == 0) swap(si, mid); si++; mid++;

TC -> O(N)
SC -> O(1)
*/

class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int si = 0, mid = 0, ei = n-1;
        while(mid <= ei) {
            if(nums[mid] == 2) {
                swap(nums, mid, ei);
                ei--;
            } else if(nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, si);
                si++;
                mid++;
            }
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
