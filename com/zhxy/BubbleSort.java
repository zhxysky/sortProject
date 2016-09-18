package com.zhxy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Collections.swap;

/**
 * 冒泡排序：从后面开始两两比较，每一轮之后最小的都会到最前面
 * 就像往上冒泡一样
 * Created by zhxy on 2016/9/18.
 */

public class BubbleSort {

    public static void main(String[] args) {
        BubbleSort bs = new BubbleSort();
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(9,8,7,6,5));
        System.out.println("before sort:"+list);
        bs.bubbleSort(list);
        System.out.println("after sort:"+list);
    }

    public void bubbleSort(List<Integer> list) {
        for(int i=0;i<list.size();i++) {
            for(int j=list.size()-1;j>i;j--) {
                compare(list,j,j-1);
            }
        }
    }

    /**
     * 比较两个位置的大小，把小的放到前面
     * @param list
     * @param k k>m
     * @param m
     */
    private void compare(List<Integer> list, int k, int m) {
        if(list.get(k) < list.get(m)) {
            swap(list, k, m);
        }
    }
}
