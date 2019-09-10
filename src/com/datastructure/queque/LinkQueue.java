package com.datastructure.queque;



/**
 * 
 * 类名称: LinkQueque   
 * 类描述: 队列链式结构             
 * 创建人: zzh       
 * 修改时间:2018年7月21日 下午1:50:02 
 * 修改备注:
 * @version 1.0.0
 */
public class LinkQueue<T> {
	
	private Node front;// 队列头，允许删除  
    private Node rear;// 队列尾，允许插入  
    private int size=0; //队列当前长度 
    
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
	
	//判空
    public boolean isEmpty(){
        return size==0;
    }
    
  //返回队首元素，但不删除
    public Node peek(){
        if(isEmpty()){
            throw new RuntimeException("空队列异常！");
        }else{
            return front;
        }
    }
    
    //入队
    public void add(T data){
    	Node newNode=new Node(data);
    	if (isEmpty()){
			front=newNode;
			rear=front;			
		}else{
			Node oldRear=rear;
			rear.next=newNode;//让尾节点的next指向新增的节点
			rear=newNode;//以新节点作为新的尾节点
		}
    	size++;
    }
    
    //出队
    public Node push(){
    	if (isEmpty()) {
            throw new RuntimeException("队列已为空");
		}
    	Node first=front;//得到队列头元素
    	front=front.next;//让front引用指向原队列头元素的下一个元素
    	first.next=null;//释放原队列头元素的next引用
    	size--;
    	return first;
    }
  //队列长度
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
