/*
Given an integer x, return true if x is a 
palindrome
, and false otherwise.

 

Example 1:

Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.
Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
  */



 /*At first i decided to be goofy , and i converted the number to a string and then converted the 
 string to an arrayu of characters and and compared the first and last letters simultaneously to get to the middle
 
 
class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }

        String number = String.valueOf(x);
        char [] numberArr = number.toCharArray();

        int left = 0;
        int right = numberArr.length - 1;
        

        while(left <= right){
            if(numberArr[left] != numberArr[right]){
                return false;
            } 
            left++;
            right--;

            
        }
    return true;
        
    }
}



 but yeah there was a faster way
 
 
 reverse the number and compare the reversed with the original number , barring negative numbers
 
 */


class Solution {
    public boolean isPalindrome(int x) {
            if(x < 0){
                return false;
            }

            if (x == 0) return true;

        int reversedNumber = 0;
        long temp = x;

        while(temp != 0){
            int digit = (int) (temp % 10);
            reversedNumber = reversedNumber * 10 + digit;
            temp = temp /10;
        }

        return (reversedNumber == x);
    }
}