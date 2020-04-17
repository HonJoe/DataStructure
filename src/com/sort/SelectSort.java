package com.sort;
/**
 * 选择排序是一种简单直观的排序方法，每次寻找序列中的最小值
 * 选择排序的时间复杂度和空间复杂度分别为 O(n2 ) 和 O(1) 
 * 类名称: SelectSort   
 * 类描述:                
 * 创建人: zzw            
 * 修改人: lenovo        
 * 修改时间:2018年6月8日 下午9:47:17 
 * 修改备注:
 * @version 1.0.0
 */
public class SelectSort {
	public static void sort(int[] num){
		int minPoint,temp;
		for (int i = 0; i < num.length; i++) {
			minPoint=i;
			for (int j = i+1; j < num.length; j++) {
				if (num[minPoint]>num[j]) {
					minPoint=j;
				}
			}
			if (num[minPoint]<num[i]) {
				temp=num[i];
				num[i]=num[minPoint];
				num[minPoint]=temp;
			}
		}
	}
}
