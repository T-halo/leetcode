package course.class01;

import java.util.Arrays;

/**
 * @author t_halo
 * @date 2022/11/11 22:18
 * <p>
 * 冒泡排序
 * <p>
 * 将第 0 个元素依次与后面的 n-i 元素进行比较
 * 如果遇到比其大（小）的元素，与其交换，然后再将该值继续与后面的元素进行比较
 * 重复此步骤，直至到最后一个元素
 * <p>
 * 时间复杂度：O(n^2)
 */
public class Code02_BubbleSort {

    private static void bubbleSort(int[] arr) {
        //条件判断
        if (arr == null || arr.length < 2) {
            return;
        }
        /*
            需要循环 n-1 次
            外层for用于控制循环次数
        */
        for (int i = 1; i < arr.length; i++) {
            /*
            在0-n-1中 找出最大值，放到n-1位置
            在0-n-2中 找出最大值，放到n-2位置
            在0-n-i中 找出最大值，放到n-i位置
             */
            // 设定一个标记，若为true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已经完成。
            boolean flag = true;
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {8, 3, 6, 7, 8, 2, 1, 9, 7, 8, 5};
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
