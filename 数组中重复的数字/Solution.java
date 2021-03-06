/*
 找出数组中重复的数字
 在一个长度为n的数组nums里所有的数字都在0~n-1的范围内。
 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 请找出数组中任意一个重复的数字 
 */
class Solution{
     public int findRepeatNumber(int[] nums) {
         Set<Integer> set = new HashSet<Integer>();

         int temp = 0;
         for(int n:nums){
             if(!set.add(n)){
                 temp = n;
                 break;
             }
         }
         return temp;
     }
}