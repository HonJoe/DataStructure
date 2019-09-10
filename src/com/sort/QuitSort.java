package com.sort;
/**
 * 
 * ������: QuitSort   
 * ������:                
 * ������: zzh           
 * �޸���: lenovo        
 * �޸�ʱ��:2018��6��21�� ����4:40:23 
 * �޸ı�ע:
 * ����˼�룺ͨ��һ�����򽫴��ż�¼�ָ�ɶ����������֣�����һ���ּ�¼�Ĺؼ��־�����һ���ֵĹؼ���С��
 * ��ɷֱ���������ּ�¼�������������Դﵽ�������������Ŀ��
 * @version 1.0.0
 */

public class QuitSort {
	public static void sort(int[] a){
		quitSort(a, 0, a.length-1);
	}
	private static void quitSort(int[] a,int l,int h) {
		int low=l,high=h;	//���λ��ֵĵ͡��߶�ָ��
		int temp=a[low];	//�ݴ�����Ԫ��
		while (low<high) {	//���ҵ�����ұ�����С��Ԫ��
			while (low<high&&a[high]>=temp) {
				high--;				
			}
			a[low]=a[high];	//��С���������С��������
			while (low<high&&a[low]<temp) {
				low++;
			}
			a[high]=a[low];	//�����������Ҳ����������			
		}//ѭ������ʱlow��high�غ�
		
		a[low]=temp;//ȷ����������մ��λ��
		if (l<high-1) {
			quitSort(a, l, high-1);
		}
		if (h>high+1) {
			quitSort(a, high+1, h);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={7,8,2,1,13,6,20,11};
		printArray(a);
		
//		BubbleSort.sort2(a);	
//		SelectSort.sort(a);
//		SelectSort.sort(a);
//		MergingSort.sort2(a);
		QuitSort.sort(a);
		printArray(a); 
	}
	
	public static void printArray(int[] arr){
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}System.out.println();
	}
}
