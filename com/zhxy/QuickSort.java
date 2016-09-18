package com.zhxy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * 快速排序是目前在实践中非常高效的一种排序算法，它不是稳定的排序算法，平均时间复杂度为O(nlogn)，最差情况下复杂度为O(n^2)。
 * 它的基本思想是：通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小，
 * 然后再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列。
 * Created by zhxy on 2016/9/18.
 */
public class QuickSort {
    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(9,8,7,6,5));
        System.out.println(list);
        qs.qsort(list,0,list.size()-1);
        System.out.println(list);
    }


    private void qsort(List<Integer> list, int left,int right) {

        if(left >= right) {
            return;
        }

        int separatorValue = list.get(left); //把最左边的值当成分隔值， 要获取  左边都比它小，右边都比它大 的 序列
        int j = right;


        for(;j>left;j--) {
            if(list.get(j) > separatorValue) {
                continue;
            }else {
                break;
            }
        }
        int i = left;
        for (;i<j;i++) {
            if(list.get(i) < separatorValue) {
                continue;
            }else {
                break;
            }
        }
        int temp = list.get(j);
        list.set(j, list.get(i));
        list.set(i, separatorValue);
        list.set(left,temp);

        qsort(list,left,i-1);
        qsort(list,i+1,right);

    }


    public void quickSort(List<Integer> list,int left,int right) {

        if(left < right) {
            int i=left;
            int j = right;
            int target = list.get(left);
            while (i < j) {
                while (i<j && list.get(j) > target) {
                    j -- ;
                }

                if(i < j) {
                    list.set(i++, list.get(j));
                }

                while (i<j && list.get(i) > target) {
                    i++;
                }

                if(i < j) {
                    list.set(j, list.get(i));
                }
            }

            list.set(i, target);
            quickSort(list,left,i-1);
            quickSort(list,i+1,right);
        }


    }
}
