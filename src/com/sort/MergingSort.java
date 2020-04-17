package com.sort;



/**
 * 
 * 类名称: MergingSort   
 * 类描述:                
 * 创建人: zzh            
 * 修改人: lenovo        
 * 修改时间:2018年6月21日 上午11:29:14 
 * 修改备注:
 * 原理：假设初始序列含有n个记录，则可以看成是n个有序的子序列，每个子序列的长度为1，然后两两归并
 * 得到【n/2】个有序子序列，每个子序列长度为1；再两两归并...如此重复直至得到一个长度为n的有序序
 * 列为止，这种排序又称2路归并排序
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
	
	//递归实现
	private static void mergeSort1(int[] data,int low,int high){
		if (low<high) {//下标不等时进行递归
			int half=(low+high)/2;	//将数组平分为A[low,half]和B[half+1,high]
			mergeSort1(data, low, half);
			mergeSort1(data, half+1, high);
			merge(data,low,high);//归并
		}
	}
	
	

		
	private static void merge(int[] a,int low,int high){
		int mid=(low+high)/2;
		int[] temp = new int[high-low+1];
        int i= low;
        int j = mid+1;
        int k = 0;
		//子序列都为有序序列
        
        //把较小的数先移到新数组
        while(i<=mid&&j<=high){
        	if (a[i]<a[j]) {
				temp[k++]=a[i++];
			}else{
				temp[k++]=a[j++];
			}
        }
        
        //把左边剩余的数移入数组
        while (i<=mid) {
			temp[k++]=a[i++];
			
		}
        
        // 把右边边剩余的数移入数组
        while(j<=high){
            temp[k++] = a[j++];
        }
        
        //赋值给a
        for(int x=0;x<temp.length;x++){
        	a[low+x]=temp[x];
        }
	}
	
	
	//非递归实现
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
	        int len_i = i + len;//归并的前半部分数组
	        int j = i + len;
	        int len_j = j +len;//归并的后半部分数组
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
	        while(i < len_i && i < a.length){//注意：这里i也有可能超过数组长度
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
