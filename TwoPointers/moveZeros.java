/**
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

 

Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:

Input: nums = [0]
Output: [0]
 

COMMENTS
THE POINTERS START AT THE BEGINNING < BOTH OF THEM 
MAKEW ONE POINTER MOVE FORWARD AND ONE STAYS
WHEN YOU FIND A NUMBER THAT ISN"T ZERO SWAP THAT NUMBER WITH THE ONE 
THAT STAYED BEHIND
AND INCREASE THE POINTER BEHIND
 */

class Solution {
    public void moveZeroes(int[] nums) {
        int right = 0; 
        int left = 0;

        while(right < nums.length){
            if(nums[right] != 0){
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
            }
            right++;
        }
    }
}