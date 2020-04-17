package com.sort;
/**
 * 
 * 类名称: QuitSort   
 * 类描述:                
 * 创建人: zzh           
 * 修改人: lenovo        
 * 修改时间:2018年6月21日 下午4:40:23 
 * 修改备注:
 * 基本思想：通过一趟排序将待排记录分割成独立的两部分，其中一部分记录的关键字均比另一部分的关键字小，
 * 则可分别对这两部分记录继续进行排序，以达到整个序列有序的目的
 * @version 1.0.0
 */

public class QuitSort {
	public static void sort(int[] a){
		quitSort(a, 0, a.length-1);
	}
	private static void quitSort(int[] a,int l,int h) {
		int low=l,high=h;	//本次划分的低、高端指针
		int temp=a[low];	//暂存枢轴元素
		while (low<high) {	//从右到左查找比枢轴小的元素
			while (low<high&&a[high]>=temp) {
				high--;				
			}
			a[low]=a[high];	//将小数放在左侧小数序列中
			while (low<high&&a[low]<temp) {
				low++;
			}
			a[high]=a[low];	//将大数放在右侧大数序列中			
		}//循环结束时low、high重合
		
		a[low]=temp;//确定枢轴的最终存放位置
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
