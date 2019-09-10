package com.datastructure.queque;



/**
 * 
 * ������: LinkQueque   
 * ������: ������ʽ�ṹ             
 * ������: zzh       
 * �޸�ʱ��:2018��7��21�� ����1:50:02 
 * �޸ı�ע:
 * @version 1.0.0
 */
public class LinkQueue<T> {
	
	private Node front;// ����ͷ������ɾ��  
    private Node rear;// ����β���������  
    private int size=0; //���е�ǰ���� 
    
	class Node{
		T data;
		Node next;
		public Node() {
			// TODO Auto-generated constructor stub
		}
		public Node(T data) {
			this.data = data;
		}
		
	}

	public  LinkQueue(){
        rear=new Node();
        front=new Node();
    }
	
	public  LinkQueue(T data){
        front=new Node(data);
        rear=front;
        size++;
    }
	
	//�п�
    public boolean isEmpty(){
        return size==0;
    }
    
  //���ض���Ԫ�أ�����ɾ��
    public Node peek(){
        if(isEmpty()){
            throw new RuntimeException("�ն����쳣��");
        }else{
            return front;
        }
    }
    
    //���
    public void add(T data){
    	Node newNode=new Node(data);
    	if (isEmpty()){
			front=newNode;
			rear=front;			
		}else{
			Node oldRear=rear;
			rear.next=newNode;//��β�ڵ��nextָ�������Ľڵ�
			rear=newNode;//���½ڵ���Ϊ�µ�β�ڵ�
		}
    	size++;
    }
    
    //����
    public Node push(){
    	if (isEmpty()) {
            throw new RuntimeException("������Ϊ��");
		}
    	Node first=front;//�õ�����ͷԪ��
    	front=front.next;//��front����ָ��ԭ����ͷԪ�ص���һ��Ԫ��
    	first.next=null;//�ͷ�ԭ����ͷԪ�ص�next����
    	size--;
    	return first;
    }
  //���г���
    public int length(){
        return size;
    }
    
    public void display(){
    	Node node=front;
    	while (node!=null&&node.data!=null) {
			System.out.println(node.data);
			node=node.next;
		}
    }
    
    public static void main(String[] args) {
        LinkQueue lq=new LinkQueue();
        lq.add(1);
        lq.add(2);
        lq.add(3);
        lq.add(4);
        lq.push();
        lq.display();
    }
}
