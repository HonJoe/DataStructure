package com.sort;
/**
 * ��������Ĺ���ԭ����ͨ�������������У�����δ�������ݣ��������������дӺ���ǰɨ�裬�ҵ���Ӧλ�ò�����
 *  һ������£����������ʱ�临�ӶȺͿռ临�Ӷȷֱ�Ϊ O(n2 ) �� O(1)
 * ������: InsertSort   
 * ������:                
 * ������: zzw            
 * �޸���: lenovo        
 * �޸�ʱ��:2018��6��8�� ����9:48:57 
 * �޸ı�ע:
 * @version 1.0.0
 */
public class InsertSort {
	public static void sort(int[] array){
		
		for (int i = 1; i < array.length; i++) {
			int insertVal = array[i];//�������	
            int index = i-1;//�������λ��(׼����ǰһ�����Ƚ�)        
            while(index>=0&&insertVal<array[index])//�����������ȱ��������С
            {               
                array[index+1]=array[index];//����arr[index] ����ƶ�           
                index--;//��index��ǰ�ƶ�
            }          
            array[index+1]=insertVal;//�Ѳ�������������λ��
		}
	}
}
