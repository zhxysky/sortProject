package com.zhxy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 插入排序：将数据分为两部分，有序部分与无序部分，一开始有序部分包含第1个元素，
 * 依次将无序的元素插入到有序部分，直到所有元素有序。插入排序又分为直接插入排序、
 * 二分插入排序、链表插入等，
 * 这里只讨论直接插入排序。它是稳定的排序算法，时间复杂度为O(n^2)
 * Created by zhxy on 2016/9/18.
 */
public class InsertSort {

    public static void main(String[] args) {
        InsertSort is = new InsertSort();
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(9,8,7,6,5));
        System.out.println("before sort:"+list);
        is.insertSort(list);
        System.out.println("after sort:"+list);
    }

    public void insertSort(List<Integer> list) {

        //把第一个元素看作是一个游戏的部分，然后把剩余的部分插入到有序部分
        for(int i=1;i<list.size();i++) {

            int j = i-1; // 0 - j 为已排序部分
//            //对  0 - j 序列循环，查找 i元素的位置
//            for(int n=j;n>=0;n--) {
//                //找到i的值大于n的值, 并且小于 n-1 的值 的地方，如果n已经为0了，则需要插入到最前面，所有的元素都要往后移动
//                if(list.get(i) < list.get(n) && n == 0 ? true : list.get(i) > list.get(n-1)) {
//                   //找到插入的位置为 n,所以n 到 j都需要往后移动一位，空出n的位置给i的值
//                    int iValue = list.get(i);
//                    int k=j;
//                    while (k>=n) {
//                        list.set(k+1,list.get(k));
//                        k -- ;
//                    }
//                    list.set(n, iValue); //n位置设置上i的值
//                }
//            }

            int iValue = list.get(i);
            // 对0到j序列，从后向前，跟iValue比较，比iValue大的，直接向后移动，直到遇到比ivalue小，或者到头的，插入iValue
            while(j>-1 && iValue< list.get(j)) {
                list.set(j + 1, list.get(j)); //比较之后直接移动
                j -- ;
            }
            list.set(j+1, iValue);

        }
    }
}
