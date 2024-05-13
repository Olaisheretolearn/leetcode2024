/**
 * You may recall that an array arr is a mountain array if and only if:

arr.length >= 3
There exists some index i (0-indexed) with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
Given an integer array arr, return the length of the longest subarray, which is a mountain. Return 0 if there is no mountain subarray.

 

 COMMENTS
 Boy am i stupid
 so at first , i assumed that the largest element would be the peak so i found the max
 and aftern i found the max , i went 

 i initialized 4 pointers 
 two from the left - left and oleft(left+1)
 two from the right right and oright(right -1);
 and if
    - if arr[oleft] > arr[left] (climbing up , that means our mountain is forming , or so i thought)
        oleft++; (find the next one )
    else - i move both oleft and left by 1 

    also same thing for right

    - if arr[oright] > arr[right]
    oright--
        else 
        oright--
        right-- , until we find a mountain

        and then i would find the distance betweeen left and right to find the mountain length
        boy was that wrong 
        
        because sometimes , most times , the max element is not the peak 

        what if the max element is at right [0 1 2 5 3 2 8]
        yeahhj , you see , wasn't very smart , didn't know until a while

        RIGHT ANSWER 
        was 
        putting a pointer at the second element , and checling if that element is grew

 */

class Solution {
    public int longestMountain(int[] arr) {
        int finalAnswer = 0;
        
        for(int i = 1; i < arr.length - 1; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                int left = i - 1;
                int right = i + 1;
                
                // Expand left
                while (left > 0 && arr[left] > arr[left - 1]) {
                    left--;
                }
                
                // Expand right
                while (right < arr.length - 1 && arr[right] > arr[right + 1]) {
                    right++;
                }
                
                // Check if it's a mountain
                finalAnswer = Math.max(finalAnswer, right - left+1);
            }
        }
        
        return finalAnswer;
    }
}