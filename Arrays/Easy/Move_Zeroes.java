/*
Maintain two pointers left and right.
If right pointer is pointing to 0, increment it.
Else swap the values of the left and the right pointer.
*/
class Solution {
    public void moveZeroes(int[] nums) {
        int left = 0, right = 0;
        while(right < nums.length) {
            if(nums[right] == 0) {
                right++;
            } else {
                swap(nums, right, left);
                right++;
                left++;
            }
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
