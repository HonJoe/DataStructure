package com.sort;
/**
 * 冒泡排序是將比較大的數字沉在最下面，较小的浮在上面
 * 类名称: BubbleSort   
 * 类描述:                
 * 创建人: zzw            
 * 修改人: lenovo        
 * 修改时间:2018年6月8日 下午9:47:48 
 * 修改备注:
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
	//优化版
	public static void sort2(int[] num){
		int temp=0;
		boolean flag=true;
		for (int i = 0; i < num.length-1&&flag; i++) {	//若flag为false证明已经排好序
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
