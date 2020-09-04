//无头双向链表

class Node{
    public int data;
    public Node next;
    public Node prev;

    public Node(int data){
        this.data = data;
    }
}

public class MyDoubleLinkedList{
    public Node head;
    public Node tail;

    //头插法
    public void addFirst(int data){
        Node node = new Node(data);
        if(this.head == null){
            this.head = node;
            this.tail = node;
            return;
        }else{
            node.next = this.head;
            this.head.prev = node;
            this.head = node;
        }
    }

    //尾插法
    public void addLast(int data){
        Node node = new Node(data);
        if(this.head == null){
            this.head = node;
            this.tail = node;
            return;
        }
        tail.next = node;
        node.prev = this.tail;
        this.tail = node;
    }

    //任意位置插入，第一个数据节点为0号下标
    public boolean addIndex(int index,int data){
        Node node = new Node(data);
        Node cur = searchIndex(index);
        if(this.head == null){
            addFirst(index);
            return;
        }
        if(this.tail == null){
            addLast(index);
            return;
        }
        cur.prev.next = node;
        node.prev = cur.prev;
        node.next = cur;
        cur.prev = node;
    }
    private Node searchIndex(int index){
        if(index < 0 || index > this.size()){
            throw new RuntimeException("不合法");
        }
        Node cur = this.head;
        while(index != null){
            cur = cur.next;
            index--;
        }
        return cur;
    }

    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        Node cur = this.head;
        while(cur != null){
            if(cur.data == key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key){
        Node cur = this.head;
        while(cur != null){
            if(cur.data == key){
                int oldDate = cur.data;
                if(cur == this.head){
                    this.head = this.head.next;
                    this.head.prev = null;
                }else{
                    cur.prev.next = cur.next;
                    if(cur.next != null){
                        cur.next.prev = cur.prev;
                    }else{
                        this.tail = cur.prev;
                    }
                }
                return oldDate;
            }
            cur = cur.next;
        }
        return -1;
    }

    //删除所有值为key的节点
    public void removeAllKey(int key){
        Node cur = this.head;
        while(cur != null){
            if(cur.data == key){
                if(cur == this.head){
                    this.head = this.head.next;
                    this.head.prev = null;
                }else{
                    cur.prev.next = cur.next;
                    if(cur.next != null){
                        cur.next.prev = cur.prev;
                    }else{
                        this.tail = cur.prev;
                    }
                }
            }
            cur = cur.next;
        }
    }

    //得到单链表的长度
    public int size(){
        Node cur = this.head;
        int count = 0;
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
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    //清除单链表
    public void clear(){
        while(this.head != null){
            Node cur = this.head.next;
            this.head.prev = null;
            this.head.next = null;
            this.head = cur;
        }
        this.tail = null;
    }
}