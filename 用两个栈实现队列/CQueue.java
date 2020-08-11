/*
用两个栈实现一个队列。队列的声明如下，请实现它的两个函数appendTail和deleteHead，
分别完成在队列尾部插入整数和在队列头部删除整数的功能。
（若队列中没有元素，deleteHead操作返回-1）
*/


//使用stack速度会很慢，因为stack继承了vector接口，而vector底层是一个Object[]数组，需要考虑空间扩容和移位的问题
//可以使用LinkedList作为stack的容器，因为LinkedList实现了Deque接口
class CQueue{
    LinkedList<Integer> stack1;
    LinkedList<Integer> stack2;
    
    public CQueue(){
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    //尾部插入元素
    public void appendTail(int value){
        stack1.add(value);
    }

    //头部删除元素
    public int deleteHead(){
        if(stack2.isEmpty()){
            if(stack1.isEmpty())
                return -1;
            while(!stack1.isEmpty()){
                stack2.add(stack1.pop());
            }
            return stack2.pop();
        }else {
            return stack2.pop();
        }
    }
}