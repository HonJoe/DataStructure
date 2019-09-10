package com.datastructure.stack;



/**
 * 
 * 类名称: LinkStack   
 * 类描述: 栈链式结构               
 * 创建人: zzh                   
 * 修改时间:2018年7月14日 下午10:57:22 
 * 修改备注:
 * @version 1.0.0
 */
public class LinkStack<T> {

	private Node<T> top;   //栈顶元素
    private int size;  //当前栈大小
    
	//链栈的节点
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
	
	//当前栈大小
    public int length(){
        return size;
    }
    
    //判空
    public boolean isEmpty(){
        return size==0;
    }
    
  //入栈：让top指向新创建的元素，新元素的next引用指向原来的栈顶元素
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
    
    //查看栈顶元素但不删除
    public Node<T> peek(){
        if(isEmpty()){
            throw new RuntimeException("空栈异常！");
        }else{
            return top;
        }
    }
    
  //出栈
    public Node<T> pop(){
    	if(isEmpty()){
            throw new RuntimeException("空栈异常！");
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
