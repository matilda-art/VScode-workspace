/*
请实现一个函数，把字符串s中的每个空格替换成“%20”
*/

class Solution{

    //方法二：遍历字符串，替换空格
    public String replaceSpace(String s){
        //单线程使用StringBuilder，速度较快
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < s.length();i++){
            char c = s.charAt(i);
            if(c == ' ')
                sb.append("%20");
            else
                sb.append(c);
        }
        return sb.toString();
    }

    //方法一：直接调用库函数
    public String replaceSpace(String s){
        s.replace(" ","%20");
    }
}