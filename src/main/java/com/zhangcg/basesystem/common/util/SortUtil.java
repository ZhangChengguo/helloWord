package com.zhangcg.basesystem.common.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangcg
 * @ClassName SortUtil
 * @description
 * @date 2021/2/22 下午4:15
 */
public class SortUtil {
    public static void main(String[] args) {
        int[] array = new int[]{3,1,7,6,2,8,5,9};
        array = insertionSort(array);
        System.out.println("直接插入排序："+Arrays.toString(array));
    }
    //直接插入排序
    public static int[] insertionSort(int[] array){
        int tmp;
        for (int i=1;i<array.length;i++){
            for (int j = 0;j<i;j++){
                if (array[i]<array[j]){
                    tmp = array[j];
                    array[j] = array[i];
                    array[i] = tmp;
                }
            }
            /*int num = array[i];
            int num1 = array[i+1];
            if (num1<num){
                tmp = num;
                array[i] = num1;
                array[i+1] = tmp;
            }*/
        }
        return array;
    }
    //希尔排序
    public static int[] shellSort(int[] array){
        Map<String,String> map = new HashMap<>();
        int gap = array.length/2;
        while (gap!=1){
            if (array[gap]>array[0]){
                int tmp = array[0];
                array[0] = array[gap];
                array[gap] = tmp;
            }
            gap = gap/2;
        }
        return array;
    }
    //简单选择排序
    //堆排序
    //冒泡排序
    //快速排序
    //归并排序
    //基数排序
}
