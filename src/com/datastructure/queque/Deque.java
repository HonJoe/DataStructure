package com.datastructure.queque;

public class Deque {
	Node head;
    Node tail;
    //�����ñ������ᱻ�־û�
    transient int size=0;
    int data;
    class Node{
        int data;
        Node pre;
        Node next;
        Node(int data,Node pre,Node next){
            this.data=data;
            this.pre=pre;
            this.next=next;
        }
        Node(int data){
            this.data=data;
        }
        Node(){
        }
    }

    public Deque(int size,Node head,Node tail){
        this.size=0;
        this.head=head;
        this.tail=tail;
    }

    public Deque(){
        head=new Node();
        tail=new Node();
    }


    //���ͷ���ڵ�(ֻ��һ��Ԫ�ص�ʱ��)
    public void addHeadNode(int data){
        Node node=new Node(data,null,null);
        head.next=node;
        node.pre=head;
        node.next=tail;
        tail.pre=node;
        size++;
    }

    //β�巨
    public void addLast(int data){
        if(head.next==null){
            addHeadNode(data);
        }else{
            Node temp=head;
            Node newNode=new Node(data);
            for(int i=0;i<size;i++){
                temp=temp.next;
            }
            newNode.pre=temp;
            newNode.next=tail;
            temp.next=newNode;
            tail.pre=newNode;
            size++;
        }
    }

    //ͷ�巨
    public void addBegin(int data){
//        add(0,data);
        if(head.next==null){
            addHeadNode(data);
            size++;
        }else {
            Node newNode = new Node(data);
            newNode.next = head.next;
            newNode.pre = head;
            head.next = newNode;
            size++;
        }
    }


    //����������ɾ��ĳһ������Ԫ������
    public String remove(int index){
        Node temp=head;
        if(index>=size){
            return "�±곬ֵ";
        }
        for(int i=0;i<size;i++){
            //�������һ����ֵ
            if(i==index){
                temp.next=temp.next.next;
                temp.next.pre=temp;
                size--;
                break;
            }
       }
		return null;
    }

}
