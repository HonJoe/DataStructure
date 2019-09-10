package com.sort;



/**
 * 
 * ������: MergingSort   
 * ������:                
 * ������: zzh            
 * �޸���: lenovo        
 * �޸�ʱ��:2018��6��21�� ����11:29:14 
 * �޸ı�ע:
 * ԭ�������ʼ���к���n����¼������Կ�����n������������У�ÿ�������еĳ���Ϊ1��Ȼ�������鲢
 * �õ���n/2�������������У�ÿ�������г���Ϊ1���������鲢...����ظ�ֱ���õ�һ������Ϊn��������
 * ��Ϊֹ�����������ֳ�2·�鲢����
 * @version 1.0.0
 */
public class MergingSort {
	
	public static void main(String[] args) {
		int a=15/2;
		int b=-15/2;
		System.out.println(a+","+b);
	}
	public static void sort(int array[]){
		mergeSort1(array, 0, array.length-1);
//		mergeSort2(array, 0, array.length-1);
	}
	
	//�ݹ�ʵ��
	private static void mergeSort1(int[] data,int low,int high){
		if (low<high) {//�±겻��ʱ���еݹ�
			int half=(low+high)/2;	//������ƽ��ΪA[low,half]��B[half+1,high]
			mergeSort1(data, low, half);
			mergeSort1(data, half+1, high);
			merge(data,low,high);//�鲢
		}
	}
	
	

		
	private static void merge(int[] a,int low,int high){
		int mid=(low+high)/2;
		int[] temp = new int[high-low+1];
        int i= low;
        int j = mid+1;
        int k = 0;
		//�����ж�Ϊ��������
        
        //�ѽ�С�������Ƶ�������
        while(i<=mid&&j<=high){
        	if (a[i]<a[j]) {
				temp[k++]=a[i++];
			}else{
				temp[k++]=a[j++];
			}
        }
        
        //�����ʣ�������������
        while (i<=mid) {
			temp[k++]=a[i++];
			
		}
        
        // ���ұ߱�ʣ�������������
        while(j<=high){
            temp[k++] = a[j++];
        }
        
        //��ֵ��a
        for(int x=0;x<temp.length;x++){
        	a[low+x]=temp[x];
        }
	}
	
	
	//�ǵݹ�ʵ��
	 public static void sort2(int[] a){
	        int len = 1;
	        while(len < a.length){
	            for(int i = 0; i < a.length; i += 2*len){
	                merge2(a, i, len);
	            }
	            len *= 2;
	        }
	    }

	    private static void merge2(int[] a, int i, int len){
	        int start = i;
	        int len_i = i + len;//�鲢��ǰ�벿������
	        int j = i + len;
	        int len_j = j +len;//�鲢�ĺ�벿������
	        int[] temp = new int[2*len];
	        int count = 0;
	        while(i < len_i && j < len_j && j < a.length){
	            if(a[i] <= a[j]){
	                temp[count++] = a[i++];
	            }
	            else{
	                temp[count++] = a[j++];
	            }
	        }
	        while(i < len_i && i < a.length){//ע�⣺����iҲ�п��ܳ������鳤��
	            temp[count++] = a[i++];
	        }
	        while(j < len_j && j < a.length){
	            temp[count++] = a[j++];
	        }
	        count = 0;
	        while(start < j && start < a.length){
	            a[start++] = temp[count++];
	        }
	    }
}
