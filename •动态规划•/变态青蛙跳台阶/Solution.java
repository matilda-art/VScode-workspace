/*
一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级
求该青蛙跳上一个n级的台阶总共有多少种跳法
*/

//动态规划  
//状态F(i)：跳上n级台阶的方法个数
//转移方程：
//  F(i)：F(i-1)+F(i-2)+……+F(0)
//  F(i-1)：F(i-2)+F(i-3)+……+F(0)
//  F(i)：F(i-1)+F(i-1)=2*F(i-1)
public class Solution {
    public int JumpFloorII(int target) {
        if(target == 0)
            return 0;
        /*int ret = 1;
        for(int i = 2;i <= target;++i)
            ret *= 2;
        return ret;*/
        return 1 << (target - 1);
    }
}