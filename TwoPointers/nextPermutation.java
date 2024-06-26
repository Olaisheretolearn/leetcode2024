/*

GOD, I HATE THIS QUESTION SO MUCH

 * A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

For example, the next permutation of arr = [1,2,3] is [1,3,2].
Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
Given an array of integers nums, find the next permutation of nums.

The replacement must be in place and use only constant extra memory.

 

Example 1:

Input: nums = [1,2,3]
Output: [1,3,2]
Example 2:

Input: nums = [3,2,1]
Output: [1,2,3]
Example 3:

Input: nums = [1,1,5]
Output: [1,5,1]
 

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 100



*************************FIRST ATTEMPT AFTER 55 minutes didn't solve all cases , WHYYYYY********
class Solution {
    public void nextPermutation(int[] nums) {
        int left = nums.length - 2;
        int right = nums.length - 1;

        while (left >= 0) {
            if (nums[right] > nums[left]) {
                // Swap elements
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                
             
                Arrays.sort(nums, left + 1, nums.length);
                return;
            } else {
                left--;
                right--;
            }
        }
        
        Arrays.sort(nums);
    }
}





 */


class Solution {
    public void nextPermutation(int[] nums) {
        int k = nums.length - 2;
        while (k >= 0 && nums[k] >= nums[k + 1]) {
            k--;
        }

        if (k == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        int l = nums.length - 1;
        while (nums[l] <= nums[k]) {
            l--;
        }

        swap(nums, k, l);
        reverse(nums, k + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

