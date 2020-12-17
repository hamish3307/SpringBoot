package com.test.springboot.java8.algorithm;

/**
 * @描述: Java常规算法
 * @Date: 2020/12/16 上午9:52
 * @Author: hha
 */
public class JavaAlgorithm {

    /**
     * @描述: 冒泡排序
     * @Date: 2020/12/16 上午10:18
     * @Author: hha
     * @param array 待排序数组
     * @Return 返回排好序的数组
     */
    public static void bubbleSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        // 临时变量
        int tmp;
        for (int i = 0; i < array.length -1; i++) {
            for (int j = 1; j < array.length - i; j++) {
                // 如果前面的数比后面的数大就交换位置
                if (array[j -1] > array[j]) {
                    tmp = array[j -1];
                    array[j -1] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }

    /**
     * @描述: 二分查找算法
     * @Date: 2020/12/16 上午9:50
     * @Author: hha
     * @param array 排好序的数组
     * @param a 要查找的数据
     */
    public static int binarySearch(int[] array, int a) {
        // 起始位
        int low = 0;
        // 高位
        int height = array.length -1;
        // 中间位
        int mid;

        while (low <= height) {
            mid = (low + height) / 2;
            if (array[mid] == a) {
                return mid + 1;
            } else if (array[mid] < a) {
                // 向右查找
                low = mid + 1;
            } else {
                // 向左查找
                height = mid - 1;
            }
        }

        return -1;

    }

    /**
     * @描述: 插入排序
     * <p>通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应的位置并插入。 插入排序非常类似于整扑克牌。
     * 在开始摸牌时，左手是空的，牌面朝下放在桌上。接着，一次从 桌上摸起一张牌，并将它插入到左手一把牌中的正确位置上。
     * 为了找到这张牌的正确位置，要将 它与手中已有的牌从右到左地进行比较。无论什么时候，左手中的牌都是排好序的。
     * 如果输入数组已经是排好序的话，插入排序出现最佳情况，其运行时间是输入规模的一个线性函 数。
     * 如果输入数组是逆序排列的，将出现最坏情况。平均情况与最坏情况一样，其时间代价是(n2)。
     * @Date: 2020/12/16 上午11:10
     * @Author: hha
     * @param array
     */
    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            // 待插入的数据
            int insertVal = array[i];
            // 被插入的位置（准备和前一个数据比较）
            int index = i -1;
            while (index >= 0 && insertVal < array[index]) {
                // 将把array[index]元素向后移动
                array[index + 1] = array[index];
                // 让index向前移动
                index   -- ;
            }
            // 把插入的数据放到合适的位置
            array[index + 1] = insertVal;
        }
    }

}
