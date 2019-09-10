package com.sort;
/**
 * 插入排序的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入
 *  一般情况下，插入排序的时间复杂度和空间复杂度分别为 O(n2 ) 和 O(1)
 * 类名称: InsertSort   
 * 类描述:                
 * 创建人: zzw            
 * 修改人: lenovo        
 * 修改时间:2018年6月8日 下午9:48:57 
 * 修改备注:
 * @version 1.0.0
 */
public class InsertSort {
	public static void sort(int[] array){
		
		for (int i = 1; i < array.length; i++) {
			int insertVal = array[i];//插入的数	
            int index = i-1;//被插入的位置(准备和前一个数比较)        
            while(index>=0&&insertVal<array[index])//如果插入的数比被插入的数小
            {               
                array[index+1]=array[index];//将把arr[index] 向后移动           
                index--;//让index向前移动
            }          
            array[index+1]=insertVal;//把插入的数放入合适位置
		}
	}
}
