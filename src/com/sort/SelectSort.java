package com.sort;
/**
 * ѡ��������һ�ּ�ֱ�۵����򷽷���ÿ��Ѱ�������е���Сֵ
 * ѡ�������ʱ�临�ӶȺͿռ临�Ӷȷֱ�Ϊ O(n2 ) �� O(1) 
 * ������: SelectSort   
 * ������:                
 * ������: zzw            
 * �޸���: lenovo        
 * �޸�ʱ��:2018��6��8�� ����9:47:17 
 * �޸ı�ע:
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
