package com.datastructure.queque;

/**
 * 
 * ������: SequenceQueue   
 * ������: ����˳��ṹ               
 * ������: zzh         
 * �޸�ʱ��:2018��8��5�� ����4:15:45 
 * �޸ı�ע:
 * @version 1.0.0
 */
public class SequenceQueue<T> {
	
	private Object[] data=null;
	private int maxSize; //��������
    private int front;  //����ͷ������ɾ��
    private int rear;   //����β���������
    
    /**
     * ���캯�������ݸ�����size��ʼ��ջ
     */
    public SequenceQueue(){
        this(10);   //Ĭ�ϴ�СΪ10
    }
    
    
    public SequenceQueue(int initialSize) {
    	if(initialSize >=0){
            this.maxSize = initialSize;
            data = new Object[initialSize];
            front = rear =0;
        }else{
            throw new RuntimeException("��ʼ����С����С��0��" + initialSize);
        }
	}
    
   //�п�
    public boolean empty(){
        return rear==front?true:false;
    }
    
  //���ض���Ԫ�أ�����ɾ��
    public T peek(){
        if(empty()){
            throw new RuntimeException("�ն����쳣��");
        }else{
            return (T) data[front];
        }    
    }
    
    //����
    public boolean add(T t){
    	int length=length();
    	if (length>=maxSize) {
    		 throw new RuntimeException("��������");
		}else{
			data[rear++]=t;
		}
    	return true;
    }
    
    //����
    public T pop(){
    	
    	if(empty()){
            throw new RuntimeException("�ն����쳣��");
        }
    	
    	T result=(T) data[front];
    	//��ǰ��
    	for(int i=1;i<=rear;i++){
    		data[i-1]=data[i];
    	}
    	data[rear--]=null;
    	return result;
    }
    
   //���г���
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
