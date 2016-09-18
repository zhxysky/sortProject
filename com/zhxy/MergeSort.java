package com.zhxy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 归并排序：
 * 将序列每相邻两个数字进行归并操作（merge)，形成floor(n/2)个序列，排序后每个序列包含两个元素
 将上述序列再次归并，形成floor(n/4)个序列，每个序列包含四个元素
 重复步骤2，直到所有元素排序完毕
 * Created by zhxy on 2016/9/18.
 */
public class MergeSort {

    public static void main(String[] args) {
        MergeSort ms = new MergeSort();
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(9, 8, 7, 6, 5));
        System.out.println("before sort:"+list);
        ms.sort(list,new ArrayList<Integer>(Arrays.asList(0,0,0,0,0)),0,list.size()-1);
        System.out.println("after sort:"+list);
    }


    /*
     递归调用
     */
    public void sort(List<Integer> list, List<Integer> tempList,int start,int end) {
        if(start < end) {
            int mid = (start + end) / 2;
            sort(list,tempList,start,mid);
            sort(list,tempList,mid+1,end);
            mergeList(list,tempList,start,mid,end);
        }
    }

    public void mergeList(List<Integer> list, List<Integer> tempList,int start,int mid, int end) {

        int i = start;
        int j = mid + 1;
        int k = 0;

        //两个列表逐个比较，按顺序加入tempList
        while (i < mid + 1 && j < end + 1) {
            if(list.get(i) < list.get(j)) {
                tempList.set(k++,list.get(i++));
            }else {
                tempList.set(k++,list.get(j++));
            }
        }

        //把剩余没有加入的元素加入tempList
        while (i < mid + 1) {
            tempList.set(k++,list.get(i++));
        }
        while (j < end + 1) {
            tempList.set(k++,list.get(j++));
        }

        //重置list
        for(i = 0,j = start;j<end+1;i++,j++) {
            list.set(j, tempList.get(i));
        }
    }


    public void merge(List<Integer> list, List<Integer> tempList,int startIndex, int midIndex, int endIndex) {
        int i = startIndex;
        int j = midIndex + 1;
        int k = 0;
        while (i < midIndex+1 && j < endIndex + 1) {
            if(list.get(i) > list.get(j)) {
                tempList.set(k++, list.get(j++));
            }else {
                tempList.set(k++, list.get(i++));
            }
        }

        while (i < midIndex + 1) {
            tempList.set(k++, list.get(i++));
        }

        while (j < endIndex + 1) {
            tempList.set(k++, list.get(j++));
        }

        for (i = 0,j=startIndex;j<endIndex+1;i++,j++) {
            list.set(j, tempList.get(i));
        }

    }

    public void mergeSort(List<Integer> list,List<Integer> tempList,int startIndex,int endIndex) {
        if(startIndex < endIndex) {
            int midIndex = (startIndex + endIndex) / 2;
            mergeSort(list,tempList,startIndex,midIndex);
            mergeSort(list,tempList,midIndex+1,endIndex);
            merge(list,tempList,startIndex,midIndex,endIndex);
        }
    }
}
