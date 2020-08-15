/*
在古老的一维模式识别中，常常需要计算连续子向量的最大和，当向量全为正数的时候，问题很好解决。
但是如果向量中包含负数，是否应该包含某个负数，并期望旁边的整数会弥补它吗？
例如：{6,-3,-2,7,-15,1,2,2}，连续子向量的最大和为8（从第0个开始，到第3个为止）
给一个数组，返回它的最大连续子序列的和
问题：数组的最大连续和
子问题：局部元素构成的数组，它的最大连续和

状态F(i)：以第i个元素结尾的最大连续子序列和
转移方程：
    F(i) = max(F(i-1)+a[i],a[i])
初始状态：F(0)=a[0]     返回值：max(F(i))
 */
 
public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        //F(i)初始化，maxsum初始化
        int maxSum = array[0],curSum = array[0];
        for(int i = 1;i < array.length;i++){
            //F(i) = max(F(i-1)+a[i],a[i])
            curSum = Math.max(curSum + array[i],array[i]);
            //maxsum = max(maxsum,F(i))
            if(curSum > maxSum)
                maxSum = curSum;
        }
        return maxSum;
    }
}