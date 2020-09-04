//无头单向非循环链表

class Node{
    public int data;
    public Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class MySingleLinkedList{
    public Node head;

    //头插法
    public void addFirst(int data){
        Node node = new Node(data);
        if(this.head == null){
            this.head = node;
            return;
        }
        node.next = this.head;
        this.head = node;
    }

    //尾插法
    public void addLast(int data){
        Node node = new Node(int data){
            if(this.head == null){
                this.head = node;
                return;
            }
            Node cur = this.head;
            while(cur != null){
                cur = cur.next;
            }
            cur.next = node;
        }
    }

    //任意位置插入，第一个数据节点为0号下标
    public boolean addIndex(int index,int data){
        Node node = new Node(data);
        Node cur = this.head;
        if(index == 0){
            addFirst(data);
            return;
        }
        if(index == this.size()){
            addLast(data);
            return;
        }
        searchIndex(index);//找到index-1的位置
        node.next = cur.next;
        cur.next = node;
    }

    private Node searchIndex(int index){
        if(index < 0 || index > this.size()){
            throw new RuntimeException("不合法");
        }
        Node cur = this.head;
        while(index-1 != 0){
            cur = cur.next;
            index--;
        }
        return cur;
    }

    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        Node cur = this.head;
        while(cur != null){
            if(cur.data = key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key){
        if(this.head == null){
            return;
        }
        if(this.head.data == key){
            this.head = this.head.next;
            return;
        }
        Node prev = searchIndex(key);
        prev.next = prev.next.next;
    }

    //删除所有值为key的节点
    public void removeAllKey(int key){
        if(this.head.data == key){
            this.head = this.head.next;
            return;
        }
        Node prev = this.head;
        Node cur = prev.next;
        while(cur != null){
            if(cur.data == key){
                prev.next = cur.next;
                cur = cur.next;
            }
            prev = cur;
            cur = cur.next;
        }
    }

    //得到单链表的长度
    public int size(){
        int count = 0;
        Node cur = this.head;
        while(cur != null){
            count++;
            cur = cur.next;
        }
        return count;
    }

    //打印单链表
    public void display(){
        Node cur = this.head;
        while(cur != null){
            System.out.println(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    //清除单链表
    public void clear(){
        this.head = null;
    }
}