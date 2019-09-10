package com.datastructure.queque;

/**
 * 
 * 类名称: SequenceQueue   
 * 类描述: 队列顺序结构               
 * 创建人: zzh         
 * 修改时间:2018年8月5日 下午4:15:45 
 * 修改备注:
 * @version 1.0.0
 */
public class SequenceQueue<T> {
	
	private Object[] data=null;
	private int maxSize; //队列容量
    private int front;  //队列头，允许删除
    private int rear;   //队列尾，允许插入
    
    /**
     * 构造函数：根据给定的size初始化栈
     */
    public SequenceQueue(){
        this(10);   //默认大小为10
    }
    
    
    public SequenceQueue(int initialSize) {
    	if(initialSize >=0){
            this.maxSize = initialSize;
            data = new Object[initialSize];
            front = rear =0;
        }else{
            throw new RuntimeException("初始化大小不能小于0：" + initialSize);
        }
	}
    
   //判空
    public boolean empty(){
        return rear==front?true:false;
    }
    
  //返回队首元素，但不删除
    public T peek(){
        if(empty()){
            throw new RuntimeException("空队列异常！");
        }else{
            return (T) data[front];
        }    
    }
    
    //插入
    public boolean add(T t){
    	int length=length();
    	if (length>=maxSize) {
    		 throw new RuntimeException("队列已满");
		}else{
			data[rear++]=t;
		}
    	return true;
    }
    
    //出队
    public T pop(){
    	
    	if(empty()){
            throw new RuntimeException("空队列异常！");
        }
    	
    	T result=(T) data[front];
    	//往前移
    	for(int i=1;i<=rear;i++){
    		data[i-1]=data[i];
    	}
    	data[rear--]=null;
    	return result;
    }
    
   //队列长度
    public int length(){
        return rear-front;
    }
    public void display(){
        for(int j=0;j<data.length;j++){
            if(data[j]!=null){
                System.out.println(data[j]);
            }
        }
    }
    
    public static void main(String[] args) {
        SequenceQueue sq=new SequenceQueue();
        sq.add(1);
        sq.add(2);
        sq.add(3);
        sq.add(4);
        sq.pop();
        sq.pop();
        
        sq.display();
    }
}
