package com.datastructure.stack;



/**
 * 
 * ������: LinkStack   
 * ������: ջ��ʽ�ṹ               
 * ������: zzh                   
 * �޸�ʱ��:2018��7��14�� ����10:57:22 
 * �޸ı�ע:
 * @version 1.0.0
 */
public class LinkStack<T> {

	private Node<T> top;   //ջ��Ԫ��
    private int size;  //��ǰջ��С
    
	//��ջ�Ľڵ�
	class Node<T>{
		T t;
		Node<T> next;
		
		public Node() {}
		public Node(T t) {		
			this.t = t;
		}
		public Node(T t, Node next) {		
			this.t = t;
			this.next = next;
		}
		
	}
	
	public LinkStack() {
		top=null;
	}
	
	//��ǰջ��С
    public int length(){
        return size;
    }
    
    //�п�
    public boolean isEmpty(){
        return size==0;
    }
    
  //��ջ����topָ���´�����Ԫ�أ���Ԫ�ص�next����ָ��ԭ����ջ��Ԫ��
    public boolean push(T t){
        if (isEmpty()) {
//        	System.out.println("empty");
			Node node = new Node(t);
			top=node;
		}else{
			Node  oldTop=top;
			top=new Node(t, oldTop);	
		}
        size++;
        return true;
    }
    
    //�鿴ջ��Ԫ�ص���ɾ��
    public Node<T> peek(){
        if(isEmpty()){
            throw new RuntimeException("��ջ�쳣��");
        }else{
            return top;
        }
    }
    
  //��ջ
    public Node<T> pop(){
    	if(isEmpty()){
            throw new RuntimeException("��ջ�쳣��");
        }else{
        	Node oldTop=top;
        	top=top.next;
        	oldTop.next=null;
        	size--;
        	return oldTop;
        }
    }
    
    public String display(){
        StringBuffer result=new StringBuffer("[head=>");
        Node temp=top;
        for(int i=0;i<size;i++){
            result.append(temp.t.toString()+"=>");
            temp=temp.next;
        }
        result.append(" end]");
        return result.toString();
    }

    public static void main(String[] args) throws Exception {
        LinkStack<Integer> linkStack=new LinkStack<>();
        linkStack.push(1);
        linkStack.push(2);
        linkStack.push(3);
        linkStack.pop();
        System.out.println(linkStack.peek().t.toString());
        System.out.println(linkStack.display());
    }
}
