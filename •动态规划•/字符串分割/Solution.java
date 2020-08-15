/*
 给定一个字符串s和一组单词dict，判断s是否可以用空格分割成一个单词序列，使得单词序列中所有的单词都是dict中的单词（序列可以包含一个或多个单词）。
例如:
给定s=“leetcode”；
dict=["leet", "code"].
返回true，因为"leetcode"可以被分割成"leet code".

问题：单词是否可以成功分割
子问题：单词前几个字符是否可以成功分割
状态F(i)：单词前i个字符是否可以成功分割
转移方程：
    F(i)：j < i && [j + 1,i]是否可以在词典中找到
    判断前i个字符整体是否可以在词典中找到
返回结果：
    F(s.length())
*/

public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        if(s.length() == 0)
            return false;
        boolean[] canBreak = new boolean[s.length() + 1];
        for(int i = 0;i <= s.length();i++){
            //整体(1,,i)
            if(dict.contains(s.substring(0,i))){
                canBreak[i] = true;
                continue;
            }
            //j < i && [j + 1,i]
            for(int j = i - 1;j > 0;j--){
                //F(j) && [j + 1,i]
                if(canBreak[j] && dict.contains(s.substring(j,i))){
                    canBreak[i] = true;
                    break;
                }
            }
        }
        return canBreak[s.length()];
    }
}