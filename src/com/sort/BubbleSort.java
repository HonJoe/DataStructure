package com.sort;
/**
 * ð�������ǌ����^��Ĕ��ֳ��������棬��С�ĸ�������
 * ������: BubbleSort   
 * ������:                
 * ������: zzw            
 * �޸���: lenovo        
 * �޸�ʱ��:2018��6��8�� ����9:47:48 
 * �޸ı�ע:
 * @version 1.0.0
 */
public class BubbleSort {
	public static void sort(int[] num){
		int temp=0;
		for (int i = 0; i < num.length-1; i++) {			
			for (int j = 0; j < num.length-1-i; j++) {
				if (num[j]>num[j+1]) {
					temp=num[j];
					num[j]=num[j+1];
					num[j+1]=temp;
				}
			}
		}
	}
	//�Ż���
	public static void sort2(int[] num){
		int temp=0;
		boolean flag=true;
		for (int i = 0; i < num.length-1&&flag; i++) {	//��flagΪfalse֤���Ѿ��ź���
			flag=false;
			for (int j = num.length-1; j >i; j--) {
				if (num[j]<num[j-1]) {
					temp=num[j];
					num[j]=num[j-1];
					num[j-1]=temp;
					flag=true;
				}
			}
		}
	}
}
