/*
大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项
（从0开始，第0项为0，第1项是1）
n<=39
*/

public class Solution {
    //动态规划
    //状态F(i):数列第i项的值
    //转移方程：F(i)：F(i-1)+F(i-2)  

    //空间复杂度O(n)
    public int Fibonacci2(int n){
        //初始值
        if(n <= 0)
            return 0;
        //申请一个数组，保存子问题的解，题目要求从第0项开始
        int[] array = new int[n + 1];
        array[0] = 0;
        array[1] = 1;
        for(int i = 0;i <= n;++i){
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n];
    }

    //空间复杂度O(1)
    public int Fibonacci3(int n){
        //初始值
        if(n <= 0)
            return 0;
        if(n == 1 || n == 2)
            return 1;
        int ret = 0;
        int fn1 = 1,fn2 = 1;

        for(int i = 3;i <= n;++i){
            //F(n)=F(n-1)+F(n-2)
            ret = fn1 + fn2;
            //更新值
            fn2 = fn1;
            fn1 = ret;
        }
        return ret;
    }


    //递归
    //时间复杂度为O(2^n)，随着n的增大呈现指数增长，效率低下
    //当输出比较大时，可能导致栈溢出
    public int Fibonacci1(int n) {
        if(n <= 0)
            return 0;
        if(n == 1 || n == 2)
            return 1;
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }
}