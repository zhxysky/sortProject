package com.zhxy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Collections.swap;

/**
 * http://www.jianshu.com/p/f5baf7f27a7e?hmsr=toutiao.io&utm_medium=toutiao.io&utm_source=toutiao.io
 * Created by zhxy on 2016/9/18.
 */
public class HeapSort {

    public static void main(String[] args) {
        HeapSort hs = new HeapSort();
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(8, 5, 7, 9, 6));
        System.out.println(list);
        hs.hsort(list,list.size());
        System.out.println(list);
    }

    public void hsort(List<Integer> list,int len) {
        int i =0;
        for (i = len/2-1;i>=0;i--) {
            heapadjust(list,i,len);
        }
        System.out.println(list);
        for(i=len-1;i>0;i--) {
            swap(list, 0, i); //把最大值交换到最后
            System.out.println("*"+list);
            heapadjust(list, 0, i); //重新调整前面的序列为最大个根堆
            System.out.println("#"+list);
        }
    }

    /**
     * 把某个节点的最大值调整在根位置
     * @param list  要调整的序列
     * @param i     要调整的节点的位置
     * @param len   要调整的序列的长度
     */
    public void heapadjust(List<Integer> list, int i,int len) {

        int child = i;
        for(;2*i + 1 < len; i = child) {
            child = 2*i+1;
            //判断左右节点大小
            if(child < len - 1 && list.get(child) < list.get(child+1)) {
                child = child+1;
            }

            //判断比较的节点与根节点的大小
            if(list.get(child) > list.get(i)) {
                swap(list,child,i);
            }else {
                break;
            }
        }
    }

    /**
     * 将序列list调整为大根堆
     * @param list 待调整的序列
     * @param i 待调整的元素下标
     * @param len 序列长度
     */
    public void heap_adjust(List<Integer> list,int i,int len) {
        int child;
        int temp;
        for(;2*i+1 < len;i=child) {
            child = 2*i + 1; //坐节点

            //比较左右两个节点哪个更大
            if(child < len - 1 && list.get(child+1) > list.get(child)) { //右节点比左节点大
                child ++; //child变成右节点位置
            }

            //如果较大的子节点大于父节点，则把较大的子节点往上移动，替换它的父节点
            if(list.get(i) < list.get(child)) {
                swap(list, i, child);
            }else {
                break;
            }
        }

    }

    public void heapSort(List<Integer> list,int len) {

        int i;
        // 调整序列的前半部分元素，调整完之后第一个元素是序列的最大的元素
        for(i= len/2 - 1;i>=0;i--) {
            heap_adjust(list,i,len);
            System.out.println("**"+list);
        }

        for(i = len -1 ;i>0;i--) {
            // 将第1个元素与当前最后一个元素交换，保证当前的最后一个位置的元素都是现在的这个序列中最大的
            swap(list,0,i);
            System.out.println("#"+list);
            // 不断缩小调整heap的范围，每一次调整完毕保证第一个元素是当前序列的最大值
            heap_adjust(list, 0, i);
            System.out.println(list);
        }
    }
}
