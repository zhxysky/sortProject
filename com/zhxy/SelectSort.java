package com.zhxy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Collections.swap;

/**
 * 选择排序：先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，
 * 然后，再从剩余未排序元素中继续寻找最小（大）元素，
 * 然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
 * Created by zhxy on 2016/9/18.
 */
public class SelectSort {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(9,8,7,6,5));
        SelectSort ss = new SelectSort();
        System.out.println("before selectSort : "+list);
        ss.selectSort(list);
        System.out.println("after selectSort : "+list);
    }



    public void selectSort(List<Integer> list) {

        for(int i=0;i<list.size();i++) {
            int minValueIndex = i; //先把第一个当作最小值
            //从剩余的当中选择最小的,并替换掉临时指定的最小值
            for(int j=i+1;j<list.size();j++) {
                if(list.get(j)<list.get(minValueIndex)) {
                    minValueIndex = j;
                }
            }

            //找到最小的下标之后，跟当前i交换
            if(minValueIndex != i) {
                swap(list,i,minValueIndex);
            }
        }


    }

}
