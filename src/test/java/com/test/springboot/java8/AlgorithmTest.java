package com.test.springboot.java8;

import com.test.springboot.java8.algorithm.JavaAlgorithm;
import org.junit.Test;

import java.util.Arrays;

/**
 * @描述: 常规算法测试
 * @Date: 2020/12/16 上午10:01
 * @Author: hha
 */
public class AlgorithmTest {

    // 无序数组
    private int[] initArray = {12, 15, 8, 11, 22, 16, 5, 21, 20, 14};

    @Test
    public void binarySearchTest() {
        int[] intArray = {12, 14, 15, 17, 18, 21, 24, 27, 30, 40};
        int index = JavaAlgorithm.binarySearch(intArray, 30);
        System.out.println("元素所在位置=》" + index);
    }

    @Test
    public void bubbleSortTest() {
        JavaAlgorithm.bubbleSort(initArray);
        Arrays.stream(initArray).forEach(item -> System.out.println(item));
    }

    @Test
    public void insertSortTest() {
        JavaAlgorithm.insertSort(initArray);
        Arrays.stream(initArray).forEach(item -> System.out.println(item));
    }


}
